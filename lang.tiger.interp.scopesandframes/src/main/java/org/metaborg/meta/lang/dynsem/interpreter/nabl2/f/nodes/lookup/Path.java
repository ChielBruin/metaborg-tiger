package org.metaborg.meta.lang.dynsem.interpreter.nabl2.f.nodes.lookup;

import org.metaborg.meta.lang.dynsem.interpreter.nabl2.f.FrameAddr;
import org.metaborg.meta.lang.dynsem.interpreter.nabl2.f.layouts.FrameUtils;
import org.metaborg.meta.lang.dynsem.interpreter.nabl2.sg.Occurrence;
import org.spoofax.interpreter.core.Tools;
import org.spoofax.interpreter.terms.IStrategoAppl;
import org.spoofax.interpreter.terms.IStrategoList;

import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.RootNode;

public final class Path extends RootNode {

	@Child
	private PathStep p;

	public Path(TruffleLanguage<?> lang, PathStep p) {
		super(lang);
		this.p = p;
		Truffle.getRuntime().createCallTarget(this);
	}

	public Occurrence getTargetDec() {
		return p.getTargetDec();
	}

	@Override
	public FrameAddr execute(VirtualFrame frame) {
		// FIXME: add cache for the FrameAddr
		return p.executeLookup(FrameUtils.asFrame(frame.getArguments()[0]));
	}

	public static Path create(IStrategoList steps, TruffleLanguage<?> lang) {
		return new Path(lang, createSteps(steps));
	}

	public static PathStep createSteps(IStrategoList steps) {
		PathStep tailStep = null;
		for (int i = steps.size() - 1; i >= 0; i--) {
			IStrategoAppl stepTerm = Tools.applAt(steps, i);
			if (Tools.hasConstructor(stepTerm, "D")) {
				assert tailStep == null;
				tailStep = D.create(stepTerm);
				continue;
			} else if (Tools.hasConstructor(stepTerm, "E")) {
				assert tailStep != null;
				tailStep = E.create(stepTerm, tailStep);
				continue;
			} else if (Tools.hasConstructor(stepTerm, "N")) {
				assert tailStep != null;
				tailStep = N.create(stepTerm, tailStep);
				continue;
			} else {
				throw new IllegalStateException("Unsupported path step: " + stepTerm);
			}
		}
		assert tailStep != null;
		return tailStep;
	}

	@Override
	public String toString() {
		return "Path: " + p.toString();
	}
}
