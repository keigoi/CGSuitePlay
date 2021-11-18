package ctlab;

import java.io.PrintWriter;
import java.util.List;

import org.cgsuite.lang.CgscriptClass;
import org.cgsuite.output.Output;

import scala.collection.immutable.Vector;

public class TryRunGame {

	public static void main(String[] args) {
	    CgscriptClass.clearAll();
	    CgscriptClass.Object().ensureInitialized();

	    Vector<Output> ret0 = org.cgsuite.lang.System.evaluate("game.grid.Clobber(\"xox|ox.\").CanonicalForm", null);
	    List<Output> outs = scala.collection.JavaConverters.asJava(ret0);
	    
	    PrintWriter wri = new PrintWriter(System.out);
	    for(Output o : outs) {
	    	o.write(wri, Output.Mode.PLAIN_TEXT);
	    }
	    wri.println();
	    wri.flush();
	    
	    System.out.println("Finished successfully.");
	}

}
