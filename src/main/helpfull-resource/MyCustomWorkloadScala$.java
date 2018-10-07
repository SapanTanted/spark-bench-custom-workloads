package com.sapan.java.example;

import scala.collection.immutable.*;
import com.ibm.sparktc.sparkbench.utils.*;
import scala.*;
import com.ibm.sparktc.sparkbench.workload.*;

public final class MyCustomWorkloadScala$ implements WorkloadDefaults, Serializable
{
    public static final MyCustomWorkloadScala$ MODULE$= new MyCustomWorkloadScala$();
    private final String name;

    public String name() {
        return this.name;
    }
    
    public MyCustomWorkloadScala apply(final Map<String, Object> m) {
        return new MyCustomWorkloadScala((String)GeneralFunctions$.MODULE$.getOrThrow((Map)m, "word"), (Option)this.apply$default$2(), (Option)this.apply$default$3(), this.apply$default$4());
    }
    
    public Option<String> apply$default$2() {
        return Option.empty();
    }
    
    public Option<String> apply$default$3() {
        return Option.empty();
    }
    
    public String apply$default$4() {
        return null;
    }
    
    public void main(final String[] args) {
        Predef$.MODULE$.println((Object)"hello world scala");
    }
    
    public MyCustomWorkloadScala apply(final String word, final Option<String> input, final Option<String> output, final String saveMode) {
        return new MyCustomWorkloadScala(word, (Option)input, (Option)output, saveMode);
    }
    
    public Option<Tuple4<String, Option<String>, Option<String>, String>> unapply(final MyCustomWorkloadScala x$0) {
        return (Option<Tuple4<String, Option<String>, Option<String>, String>>)((x$0 == null) ? None$.MODULE$ : new Some((Object)new Tuple4((Object)x$0.word(), (Object)x$0.input(), (Object)x$0.output(), (Object)x$0.saveMode())));
    }
    
    public Option<String> $lessinit$greater$default$2() {
        return Option.empty();
    }
    
    public Option<String> $lessinit$greater$default$3() {
        return Option.empty();
    }
    
    public String $lessinit$greater$default$4() {
        return null;
    }
    
    private Object readResolve() {
        return MyCustomWorkloadScala$.MODULE$;
    }
    
    private MyCustomWorkloadScala$() {

        this.name = "my-custom-workload-scala";
    }
}
