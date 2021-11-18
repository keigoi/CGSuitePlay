package ctlab;

import static scala.collection.JavaConverters.asJava;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;

import org.cgsuite.lang.CgscriptClass;
import org.cgsuite.lang.CgscriptClasspath;
import org.cgsuite.output.Output;

import scala.Symbol;
import scala.collection.mutable.AnyRefMap;

public class LoadAndRun {

	public static void main(String[] args) {
	    CgscriptClass.clearAll();
	    CgscriptClass.Object().ensureInitialized();
	    
	    CgscriptClasspath.declareClasspathRoot(new File("scripts/"), false);
	    
	    AnyRefMap<Symbol, Object> varMap = new AnyRefMap<>(); 

	    List<Output> outs = asJava( org.cgsuite.lang.System.evaluateOrException("MyGame(\"xox|ox.\").CanonicalForm", varMap) );
	    
	    PrintWriter wri = new PrintWriter(System.out);
	    for(Output o : outs) {
	    	o.write(wri, Output.Mode.PLAIN_TEXT);
	    }
	    wri.println();
	    wri.flush();
	    
	    System.out.println("Finished successfully.");

	}

}
