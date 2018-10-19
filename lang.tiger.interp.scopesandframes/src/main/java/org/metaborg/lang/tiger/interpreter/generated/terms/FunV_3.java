package org.metaborg.lang.tiger.interpreter.generated.terms;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.metaborg.lang.tiger.interp.scopesandframes.nodes.Exp;
import org.spoofax.interpreter.core.Tools;
import org.spoofax.interpreter.terms.IStrategoAppl;
import org.spoofax.interpreter.terms.IStrategoTerm;

import com.oracle.truffle.api.CompilerAsserts;
import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;

public final class FunV_3 extends V {
	public final static String CONSTRUCTOR = "FunV";

	public final static int ARITY = 3;

	public FunV_3(com.oracle.truffle.api.object.DynamicObject _1, List_Occurrence2c7e4fe8 _2, Exp _3) {
		this(_1, _2, _3, null);
	}

	private FunV_3(com.oracle.truffle.api.object.DynamicObject _1, List_Occurrence2c7e4fe8 _2, Exp _3,
			IStrategoTerm strategoTerm) {
		this._1 = _1;
		this._2 = _2;
		this._3 = _3;
		this.strategoTerm = strategoTerm;
	}

	private final com.oracle.truffle.api.object.DynamicObject _1;

	private final List_Occurrence2c7e4fe8 _2;

	private final Exp _3;

	public com.oracle.truffle.api.object.DynamicObject get_1() {
		return _1;
	}

	public List_Occurrence2c7e4fe8 get_2() {
		return _2;
	}

	public Exp get_3() {
		return _3;
	}

	@TruffleBoundary
	public static FunV_3 create(IStrategoTerm term) {
		CompilerAsserts.neverPartOfCompilation();
		assert term != null;
		assert Tools.isTermAppl(term);
		assert Tools.hasConstructor((IStrategoAppl) term, CONSTRUCTOR, ARITY);
		return new FunV_3(null, List_Occurrence2c7e4fe8.create(term.getSubterm(1)), Exp.create(term.getSubterm(2)),
				term);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FunV_3 other = (FunV_3) obj;
		if (_1 == null) {
			if (other._1 != null) {
				return false;
			}
		} else if (!_1.equals(other._1)) {
			return false;
		}
		if (_2 == null) {
			if (other._2 != null) {
				return false;
			}
		} else if (!_2.equals(other._2)) {
			return false;
		}
		if (_3 == null) {
			if (other._3 != null) {
				return false;
			}
		} else if (!_3.equals(other._3)) {
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
		sb.append(", ");
		sb.append(_3);
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
		return new HashCodeBuilder().append(_3).append(_2).append(_1).toHashCode();
	}
}