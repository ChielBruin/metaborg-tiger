package org.metaborg.lang.tiger.interpreter.generated.terms;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.spoofax.interpreter.core.Tools;
import org.spoofax.interpreter.terms.IStrategoAppl;
import org.spoofax.interpreter.terms.IStrategoTerm;

import com.oracle.truffle.api.CompilerAsserts;
import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;

public final class AddrLte_2 extends Condition {
	public final static String CONSTRUCTOR = "AddrLte";

	public final static int ARITY = 2;

	public AddrLte_2(org.metaborg.meta.lang.dynsem.interpreter.nabl2.f.Addr _1, int _2) {
		this(_1, _2, null);
	}

	private AddrLte_2(org.metaborg.meta.lang.dynsem.interpreter.nabl2.f.Addr _1, int _2, IStrategoTerm strategoTerm) {
		this._1 = _1;
		this._2 = _2;
		this.strategoTerm = strategoTerm;
	}

	private final org.metaborg.meta.lang.dynsem.interpreter.nabl2.f.Addr _1;

	private final int _2;

	public org.metaborg.meta.lang.dynsem.interpreter.nabl2.f.Addr get_1() {
		return _1;
	}

	public int get_2() {
		return _2;
	}

	@TruffleBoundary
	public static AddrLte_2 create(IStrategoTerm term) {
		CompilerAsserts.neverPartOfCompilation();
		assert term != null;
		assert Tools.isTermAppl(term);
		assert Tools.hasConstructor((IStrategoAppl) term, CONSTRUCTOR, ARITY);
		return new AddrLte_2(null, Tools.asJavaInt(term.getSubterm(1)), term);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AddrLte_2 other = (AddrLte_2) obj;
		if (_1 == null) {
			if (other._1 != null) {
				return false;
			}
		} else if (!_1.equals(other._1)) {
			return false;
		}
		if (_2 != other._2) {
			return false;
		}
		return true;
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
		sb.append(", ");
		sb.append(_2);
		sb.append(")");
		return sb.toString();
	}

	@CompilationFinal
	private boolean hashCodeComputed;

	@CompilationFinal
	private int hashcode;

	@Override
	public int hashCode() {
		if (!hashCodeComputed) {
			CompilerDirectives.transferToInterpreterAndInvalidate();
			hashcode = makeHashCode();
			hashCodeComputed = true;
		}
		return hashcode;
	}

	@TruffleBoundary
	private int makeHashCode() {
		return new HashCodeBuilder().append(_2).append(_1).toHashCode();
	}
}