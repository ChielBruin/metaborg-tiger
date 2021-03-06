package org.metaborg.lang.tiger.interp.scopesandframes.nodes.numbers;

import org.metaborg.lang.tiger.interp.scopesandframes.nodes.Exp;
import org.metaborg.lang.tiger.interp.scopesandframes.values.IntV_1;
import org.spoofax.interpreter.core.Tools;
import org.spoofax.interpreter.terms.IStrategoAppl;
import org.spoofax.interpreter.terms.IStrategoTerm;

import com.oracle.truffle.api.CompilerAsserts;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.Cached;
import com.oracle.truffle.api.dsl.Specialization;

public abstract class Int_1 extends Exp {
	public final static String CONSTRUCTOR = "Int";

	public final static int ARITY = 1;

	public Int_1(String _1) {
		this(_1, null);
	}

	public Int_1(String _1, IStrategoTerm strategoTerm) {
		this._1 = _1;
		this.strategoTerm = strategoTerm;
	}

	private final String _1;

	@Specialization
	public IntV_1 doCached(@Cached("parse()") IntV_1 cached) {
		return cached;
	}

	protected IntV_1 parse() {
		return new IntV_1(Integer.parseInt(_1));
	}

	@TruffleBoundary
	public static Int_1 create(IStrategoTerm term) {
		CompilerAsserts.neverPartOfCompilation();
		assert term != null;
		assert Tools.isTermAppl(term);
		assert Tools.hasConstructor((IStrategoAppl) term, CONSTRUCTOR, ARITY);
		return Int_1NodeGen.create(Tools.asJavaString(term.getSubterm(0)), term);
	}

	private final IStrategoTerm strategoTerm;

	@Override
	public int size() {
		return ARITY;
	}

	@Override
	public boolean hasStrategoTerm() {
		return strategoTerm != null;
	}

	@Override
	public IStrategoTerm getStrategoTerm() {
		return strategoTerm;
	}

	@TruffleBoundary
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append(CONSTRUCTOR);
		sb.append("(");
		sb.append(_1);
		sb.append(")");
		return sb.toString();
	}

}