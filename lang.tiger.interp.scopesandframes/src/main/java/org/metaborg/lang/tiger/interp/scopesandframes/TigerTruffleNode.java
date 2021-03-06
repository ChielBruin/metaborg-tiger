package org.metaborg.lang.tiger.interp.scopesandframes;

import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.TruffleLanguage.ContextReference;
import com.oracle.truffle.api.nodes.Node;

public class TigerTruffleNode extends Node {

	public TigerTruffleNode() {
		super();
	}

	@CompilationFinal
	private ContextReference<TigerContext> ctxRef;

	public final TigerContext context() {
		if (ctxRef == null) {
			ctxRef = this.getRootNode().getLanguage(TigerLanguage.class).getContextReference();
		}
		return ctxRef.get();
	}

	// FIXME: make final
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	// FIXME: make final
	@Override
	public int hashCode() {
		return super.hashCode();
	}

}
