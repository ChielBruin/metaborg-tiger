package org.metaborg.lang.tiger.interpreter.natives;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Supplier;
import org.metaborg.lang.tiger.interpreter.generated.terms.*;
import org.metaborg.meta.lang.dynsem.interpreter.nodes.building.NativeOpBuild;
import org.metaborg.meta.lang.dynsem.interpreter.nodes.building.TermBuild;
import mb.nabl2.interpreter.*;
import mb.nabl2.stratego.*;
import mb.nabl2.stratego.TermIndex;
import mb.nabl2.terms.*;
import mb.nabl2.terms.build.*;
import org.spoofax.interpreter.terms.IStrategoTerm;
import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.source.SourceSection;

@SuppressWarnings("unused") @NodeChild(value = "term", type = TermBuild.class) public abstract class nabl2_init_1 extends NativeOpBuild 
{ 
  public nabl2_init_1 (SourceSection source) 
  { 
    super(source);
  }

  @Specialization public NaBL2 doGet(org.metaborg.meta.lang.dynsem.interpreter.terms.ITerm term)
  { 
    return NaBL2.create(getSolution());
  }

  public static NativeOpBuild create(SourceSection source, TermBuild term)
  { 
    return nabl2_init_1NodeGen.create(source, term);
  }
}