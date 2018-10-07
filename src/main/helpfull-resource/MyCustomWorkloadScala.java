package com.sapan.java.example;

import scala.collection.Seq;
import scala.collection.Seq$;
import scala.collection.immutable.Map;
import scala.reflect.*;
import scala.collection.immutable.*;
import com.ibm.sparktc.sparkbench.workload.*;
import org.apache.spark.sql.*;
import com.ibm.sparktc.sparkbench.utils.*;
import scala.reflect.api.JavaUniverse;
import scala.reflect.runtime.*;
import scala.reflect.api.*;
import scala.collection.*;
import scala.reflect.runtime.package$;
import scala.runtime.*;
import scala.*;

@ScalaSignature(bytes = "\u0006\u0001\t\u0015q!B\u0001\u0003\u0011\u0003Y\u0011!F'z\u0007V\u001cHo\\7X_J\\Gn\\1e'\u000e\fG.\u0019\u0006\u0003\u0007\u0011\tq!\u001a=b[BdWM\u0003\u0002\u0006\r\u0005)1oY1mC*\u0011q\u0001C\u0001\u0006g\u0006\u0004\u0018M\u001c\u0006\u0002\u0013\u0005\u00191m\\7\u0004\u0001A\u0011A\"D\u0007\u0002\u0005\u0019)aB\u0001E\u0001\u001f\t)R*_\"vgR|WnV8sW2|\u0017\rZ*dC2\f7\u0003B\u0007\u0011+\u0005\u0002\"!E\n\u000e\u0003IQ\u0011!B\u0005\u0003)I\u0011a!\u00118z%\u00164\u0007C\u0001\f \u001b\u00059\"B\u0001\r\u001a\u0003!9xN]6m_\u0006$'B\u0001\u000e\u001c\u0003)\u0019\b/\u0019:lE\u0016t7\r\u001b\u0006\u00039u\tqa\u001d9be.$8M\u0003\u0002\u001f\u0011\u0005\u0019\u0011NY7\n\u0005\u0001:\"\u0001E,pe.dw.\u00193EK\u001a\fW\u000f\u001c;t!\t\t\"%\u0003\u0002$%\ta1+\u001a:jC2L'0\u00192mK\")Q%\u0004C\u0001M\u00051A(\u001b8jiz\"\u0012a\u0003\u0005\bQ5\u0011\r\u0011\"\u0001*\u0003\u0011q\u0017-\\3\u0016\u0003)\u0002\"a\u000b\u0019\u000e\u00031R!!\f\u0018\u0002\t1\fgn\u001a\u0006\u0002_\u0005!!.\u0019<b\u0013\t\tDF\u0001\u0004TiJLgn\u001a\u0005\u0007g5\u0001\u000b\u0011\u0002\u0016\u0002\u000b9\fW.\u001a\u0011\t\u000bUjA\u0011\t\u001c\u0002\u000b\u0005\u0004\b\u000f\\=\u0015\u0007]\n\u0019\u000b\u0005\u0002\rq\u0019!aB\u0001!:'\u0015A\u0004CO\u001f\"!\t12(\u0003\u0002=/\tAqk\u001c:lY>\fG\r\u0005\u0002\u0012}%\u0011qH\u0005\u0002\b!J|G-^2u\u0011!\t\u0005H!f\u0001\n\u0003\u0011\u0015\u0001B<pe\u0012,\u0012a\u0011\t\u0003\t\u001es!!E#\n\u0005\u0019\u0013\u0012A\u0002)sK\u0012,g-\u0003\u00022\u0011*\u0011aI\u0005\u0005\t\u0015b\u0012\t\u0012)A\u0005\u0007\u0006)qo\u001c:eA!AA\n\u000fBK\u0002\u0013\u0005Q*A\u0003j]B,H/F\u0001O!\r\trjQ\u0005\u0003!J\u0011aa\u00149uS>t\u0007\u0002\u0003*9\u0005#\u0005\u000b\u0011\u0002(\u0002\r%t\u0007/\u001e;!\u0011!!\u0006H!f\u0001\n\u0003i\u0015AB8viB,H\u000f\u0003\u0005Wq\tE\t\u0015!\u0003O\u0003\u001dyW\u000f\u001e9vi\u0002B\u0001\u0002\u0017\u001d\u0003\u0016\u0004%\tAQ\u0001\tg\u00064X-T8eK\"A!\f\u000fB\tB\u0003%1)A\u0005tCZ,Wj\u001c3fA!)Q\u0005\u000fC\u00019R)q'\u00180`A\")\u0011i\u0017a\u0001\u0007\"9Aj\u0017I\u0001\u0002\u0004q\u0005b\u0002+\\!\u0003\u0005\rA\u0014\u0005\b1n\u0003\n\u00111\u0001D\u0011\u0015\u0011\u0007\b\"\u0011d\u0003)!wnV8sW2|\u0017\r\u001a\u000b\u0005Iz\f\u0019\u0001\u0005\u0002fw:\u0011a\r\u001f\b\u0003OVt!\u0001\u001b:\u000f\u0005%|gB\u00016n\u001b\u0005Y'B\u00017\u000b\u0003\u0019a$o\\8u}%\ta.A\u0002pe\u001eL!\u0001]9\u0002\r\u0005\u0004\u0018m\u00195f\u0015\u0005q\u0017BA:u\u0003\u0015\u0019\b/\u0019:l\u0015\t\u0001\u0018/\u0003\u0002wo\u0006\u00191/\u001d7\u000b\u0005M$\u0018BA={\u0003\u001d\u0001\u0018mY6bO\u0016T!A^<\n\u0005ql(!\u0003#bi\u00064%/Y7f\u0015\tI(\u0010\u0003\u0005\u0000CB\u0005\t\u0019AA\u0001\u0003\t!g\rE\u0002\u0012\u001f\u0012Dq!!\u0002b\u0001\u0004\t9!\u0001\u0007ta\u0006\u00148nU3tg&|g\u000e\u0005\u0003\u0002\n\u0005-Q\"\u0001>\n\u0007\u00055!P\u0001\u0007Ta\u0006\u00148nU3tg&|g\u000eC\u0005\u0002\u0012a\n\t\u0011\"\u0001\u0002\u0014\u0005!1m\u001c9z)%9\u0014QCA\f\u00033\tY\u0002\u0003\u0005B\u0003\u001f\u0001\n\u00111\u0001D\u0011!a\u0015q\u0002I\u0001\u0002\u0004q\u0005\u0002\u0003+\u0002\u0010A\u0005\t\u0019\u0001(\t\u0011a\u000by\u0001%AA\u0002\rC\u0011\"a\b9#\u0003%\t!!\t\u0002)\u0011|wk\u001c:lY>\fG\r\n3fM\u0006,H\u000e\u001e\u00132+\t\t\u0019C\u000b\u0003\u0002\u0002\u0005\u00152FAA\u0014!\u0011\tI#a\r\u000e\u0005\u0005-\"\u0002BA\u0017\u0003_\t\u0011\"\u001e8dQ\u0016\u001c7.\u001a3\u000b\u0007\u0005E\"#\u0001\u0006b]:|G/\u0019;j_:LA!!\u000e\u0002,\t\tRO\\2iK\u000e\\W\r\u001a,be&\fgnY3\t\u0013\u0005e\u0002(%A\u0005\u0002\u0005m\u0012AD2paf$C-\u001a4bk2$H%M\u000b\u0003\u0003{Q3aQA\u0013\u0011%\t\t\u0005OI\u0001\n\u0003\t\u0019%\u0001\bd_BLH\u0005Z3gCVdG\u000f\n\u001a\u0016\u0005\u0005\u0015#f\u0001(\u0002&!I\u0011\u0011\n\u001d\u0012\u0002\u0013\u0005\u00111I\u0001\u000fG>\u0004\u0018\u0010\n3fM\u0006,H\u000e\u001e\u00134\u0011%\ti\u0005OI\u0001\n\u0003\tY$\u0001\bd_BLH\u0005Z3gCVdG\u000f\n\u001b\t\u0011\u0005E\u0003(!A\u0005B%\nQ\u0002\u001d:pIV\u001cG\u000f\u0015:fM&D\b\"CA+q\u0005\u0005I\u0011AA,\u00031\u0001(o\u001c3vGR\f%/\u001b;z+\t\tI\u0006E\u0002\u0012\u00037J1!!\u0018\u0013\u0005\rIe\u000e\u001e\u0005\n\u0003CB\u0014\u0011!C\u0001\u0003G\na\u0002\u001d:pIV\u001cG/\u00127f[\u0016tG\u000f\u0006\u0003\u0002f\u0005-\u0004cA\t\u0002h%\u0019\u0011\u0011\u000e\n\u0003\u0007\u0005s\u0017\u0010\u0003\u0006\u0002n\u0005}\u0013\u0011!a\u0001\u00033\n1\u0001\u001f\u00132\u0011%\t\t\bOA\u0001\n\u0003\n\u0019(A\bqe>$Wo\u0019;Ji\u0016\u0014\u0018\r^8s+\t\t)\b\u0005\u0004\u0002x\u0005u\u0014QM\u0007\u0003\u0003sR1!a\u001f\u0013\u0003)\u0019w\u000e\u001c7fGRLwN\\\u0005\u0005\u0003\u007f\nIH\u0001\u0005Ji\u0016\u0014\u0018\r^8s\u0011%\t\u0019\tOA\u0001\n\u0003\t))\u0001\u0005dC:,\u0015/^1m)\u0011\t9)!$\u0011\u0007E\tI)C\u0002\u0002\fJ\u0011qAQ8pY\u0016\fg\u000e\u0003\u0006\u0002n\u0005\u0005\u0015\u0011!a\u0001\u0003KB\u0011\"!%9\u0003\u0003%\t%a%\u0002\u0011!\f7\u000f[\"pI\u0016$\"!!\u0017\t\u0013\u0005]\u0005(!A\u0005B\u0005e\u0015\u0001\u0003;p'R\u0014\u0018N\\4\u0015\u0003)B\u0011\"!(9\u0003\u0003%\t%a(\u0002\r\u0015\fX/\u00197t)\u0011\t9)!)\t\u0015\u00055\u00141TA\u0001\u0002\u0004\t)\u0007C\u0004\u0002&R\u0002\r!a*\u0002\u00035\u0004b\u0001RAU\u0007\u0006\u0015\u0014bAAV\u0011\n\u0019Q*\u00199\t\u000f\u0005=V\u0002\"\u0001\u00022\u0006!Q.Y5o)\u0011\t\u0019,!/\u0011\u0007E\t),C\u0002\u00028J\u0011A!\u00168ji\"A\u00111XAW\u0001\u0004\ti,\u0001\u0003be\u001e\u001c\b\u0003B\t\u0002@\u000eK1!!1\u0013\u0005\u0015\t%O]1z\u0011!)T\"!A\u0005\u0002\u0006\u0015G#C\u001c\u0002H\u0006%\u00171ZAg\u0011\u0019\t\u00151\u0019a\u0001\u0007\"AA*a1\u0011\u0002\u0003\u0007a\n\u0003\u0005U\u0003\u0007\u0004\n\u00111\u0001O\u0011!A\u00161\u0019I\u0001\u0002\u0004\u0019\u0005\"CAi\u001b\u0005\u0005I\u0011QAj\u0003\u001d)h.\u00199qYf$B!!6\u0002^B!\u0011cTAl!\u001d\t\u0012\u0011\\\"O\u001d\u000eK1!a7\u0013\u0005\u0019!V\u000f\u001d7fi!I\u0011q\\Ah\u0003\u0003\u0005\raN\u0001\u0004q\u0012\u0002\u0004\"CAr\u001bE\u0005I\u0011AA\"\u0003m!C.Z:tS:LG\u000fJ4sK\u0006$XM\u001d\u0013eK\u001a\fW\u000f\u001c;%e!I\u0011q]\u0007\u0012\u0002\u0013\u0005\u00111I\u0001\u001cI1,7o]5oSR$sM]3bi\u0016\u0014H\u0005Z3gCVdG\u000fJ\u001a\t\u0013\u0005-X\"%A\u0005\u0002\u0005m\u0012a\u0007\u0013mKN\u001c\u0018N\\5uI\u001d\u0014X-\u0019;fe\u0012\"WMZ1vYR$C\u0007C\u0005\u0002p6\t\n\u0011\"\u0001\u0002D\u0005y\u0011\r\u001d9ms\u0012\"WMZ1vYR$#\u0007C\u0005\u0002t6\t\n\u0011\"\u0001\u0002D\u0005y\u0011\r\u001d9ms\u0012\"WMZ1vYR$3\u0007C\u0005\u0002x6\t\n\u0011\"\u0001\u0002<\u0005y\u0011\r\u001d9ms\u0012\"WMZ1vYR$C\u0007C\u0005\u0002|6\t\t\u0011\"\u0003\u0002~\u0006Y!/Z1e%\u0016\u001cx\u000e\u001c<f)\t\ty\u0010E\u0002,\u0005\u0003I1Aa\u0001-\u0005\u0019y%M[3di\u0002")
public class MyCustomWorkloadScala implements Workload, Product, Serializable
{
    private final String word;
    private final Option<String> input;
    private final Option<String> output;
    private final String saveMode;
    
    public static String apply$default$4() {
        return MyCustomWorkloadScala$.MODULE$.apply$default$4();
    }
    
    public static Option<String> apply$default$3() {
        return MyCustomWorkloadScala$.MODULE$.apply$default$3();
    }
    
    public static Option<String> apply$default$2() {
        return MyCustomWorkloadScala$.MODULE$.apply$default$2();
    }
    
    public static String $lessinit$greater$default$4() {
        return MyCustomWorkloadScala$.MODULE$.$lessinit$greater$default$4();
    }
    
    public static Option<String> $lessinit$greater$default$3() {
        return MyCustomWorkloadScala$.MODULE$.$lessinit$greater$default$3();
    }
    
    public static Option<String> $lessinit$greater$default$2() {
        return MyCustomWorkloadScala$.MODULE$.$lessinit$greater$default$2();
    }
    
    public static Option<Tuple4<String, Option<String>, Option<String>, String>> unapply(final MyCustomWorkloadScala x$0) {
        return MyCustomWorkloadScala$.MODULE$.unapply(x$0);
    }
    
    public static MyCustomWorkloadScala apply(final String word, final Option<String> input, final Option<String> output, final String saveMode) {
        return MyCustomWorkloadScala$.MODULE$.apply(word, input, output, saveMode);
    }
    
    public static void main(final String[] args) {
        MyCustomWorkloadScala$.MODULE$.main(args);
    }
    
    public static MyCustomWorkloadScala apply(final Map<String, Object> m) {
        return MyCustomWorkloadScala$.MODULE$.apply(m);
    }
    
    public static String name() {
        return MyCustomWorkloadScala$.MODULE$.name();
    }
    
    public Dataset<Row> reconcileSchema(final Dataset<Row> dataFrame) {
        return (Dataset<Row>)Workload$class.reconcileSchema((Workload)this, (Dataset)dataFrame);
    }
    
    public Dataset<Row> run(final SparkSession spark) {
        return (Dataset<Row>)Workload$class.run((Workload)this, spark);
    }
    
    public Map<String, Object> toMap() {
        return (Map<String, Object>)Workload$class.toMap((Workload)this);
    }
    
    public String word() {
        return this.word;
    }
    
    public Option<String> input() {
        return this.input;
    }
    
    public Option<String> output() {
        return this.output;
    }
    
    public String saveMode() {
        return this.saveMode;
    }
    
    public Dataset<Row> doWorkload(final Option<Dataset<Row>> df, final SparkSession sparkSession) {
        final long timestamp = System.currentTimeMillis();
            final long total_time2;
            final long total_time = total_time2 = 10000;
//            final Seq seq = (Seq)Seq$.MODULE$.apply((Seq)Predef$.MODULE$.wrapRefArray((Object[])new MyCustomWorkloadScalaResult[] { new MyCustomWorkloadScalaResult("my-custom-workload-scala", timestamp, total_time2, this.word()) }));
            final JavaUniverse $u = package$.MODULE$.universe();
            final JavaUniverse.JavaMirror $m = package$.MODULE$.universe().runtimeMirror(MyCustomWorkloadScala.class.getClassLoader());
            return (Dataset<Row>)sparkSession.emptyDataFrame();
    }
    
    public Option<Dataset<Row>> doWorkload$default$1() {
        return Option.empty();
    }
    
    public MyCustomWorkloadScala copy(final String word, final Option<String> input, final Option<String> output, final String saveMode) {
        return new MyCustomWorkloadScala(word, input, output, saveMode);
    }
    
    public String copy$default$1() {
        return this.word();
    }
    
    public Option<String> copy$default$2() {
        return this.input();
    }
    
    public Option<String> copy$default$3() {
        return this.output();
    }
    
    public String copy$default$4() {
        return this.saveMode();
    }
    
    public String productPrefix() {
        return "MyCustomWorkloadScala";
    }
    
    public int productArity() {
        return 4;
    }
    
    public Object productElement(final int x$1) {
        Object o = null;
        switch (x$1) {
            default: {
                throw new IndexOutOfBoundsException(BoxesRunTime.boxToInteger(x$1).toString());
            }
            case 3: {
                o = this.saveMode();
                break;
            }
            case 2: {
                o = this.output();
                break;
            }
            case 1: {
                o = this.input();
                break;
            }
            case 0: {
                o = this.word();
                break;
            }
        }
        return o;
    }
    
    public Iterator<Object> productIterator() {
        return (Iterator<Object>)ScalaRunTime$.MODULE$.typedProductIterator((Product)this);
    }
    
    public boolean canEqual(final Object x$1) {
        return x$1 instanceof MyCustomWorkloadScala;
    }
    
    @Override
    public int hashCode() {
        return ScalaRunTime$.MODULE$._hashCode((Product)this);
    }
    
    @Override
    public String toString() {
        return ScalaRunTime$.MODULE$._toString((Product)this);
    }
    
    @Override
    public boolean equals(final Object x$1) {
        if (this != x$1) {
            if (x$1 instanceof MyCustomWorkloadScala) {
                final MyCustomWorkloadScala myCustomWorkloadScala = (MyCustomWorkloadScala)x$1;
                final String word = this.word();
                final String word2 = myCustomWorkloadScala.word();
                boolean b = false;
                Label_0173: {
                    Label_0172: {
                        if (word == null) {
                            if (word2 != null) {
                                break Label_0172;
                            }
                        }
                        else if (!word.equals(word2)) {
                            break Label_0172;
                        }
                        final Option<String> input = this.input();
                        final Option<String> input2 = myCustomWorkloadScala.input();
                        if (input == null) {
                            if (input2 != null) {
                                break Label_0172;
                            }
                        }
                        else if (!input.equals(input2)) {
                            break Label_0172;
                        }
                        final Option<String> output = this.output();
                        final Option<String> output2 = myCustomWorkloadScala.output();
                        if (output == null) {
                            if (output2 != null) {
                                break Label_0172;
                            }
                        }
                        else if (!output.equals(output2)) {
                            break Label_0172;
                        }
                        final String saveMode = this.saveMode();
                        final String saveMode2 = myCustomWorkloadScala.saveMode();
                        if (saveMode == null) {
                            if (saveMode2 != null) {
                                break Label_0172;
                            }
                        }
                        else if (!saveMode.equals(saveMode2)) {
                            break Label_0172;
                        }
                        if (myCustomWorkloadScala.canEqual(this)) {
                            b = true;
                            break Label_0173;
                        }
                    }
                    b = false;
                }
                if (b) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    public MyCustomWorkloadScala(final String word, final Option<String> input, final Option<String> output, final String saveMode) {
        this.word = word;
        this.input = input;
        this.output = output;
        this.saveMode = saveMode;
        Workload$class.$init$((Workload)this);
        Product$class.$init$((Product)this);
    }
}
