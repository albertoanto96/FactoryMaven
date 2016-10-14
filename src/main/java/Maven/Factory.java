package Maven;

import java.util.HashMap;
import java.util.concurrent.ExecutionException;
import org.apache.log4j.Logger;

public class Factory {
    private static Factory instance;
    private HashMap<String,Command> cache;
    final static Logger logger = Logger.getLogger(Factory.class);

    public Factory(){
        cache=new HashMap<String,Command>();
        logger.info("se crea cache");
//        logger.wa

    }
    public static Factory getInstance(){
        if (instance==null) instance=new Factory();
        return instance;
    }
    public Command getCommand (String cmd) throws Exception {
        Command c= cache.get(cmd);

        if(c==null){
            logger.info("class loader crea instancia de Command");

            Class cl=Class.forName("Maven."+cmd);
            c= (Command) cl.newInstance();
            cache.put(cmd,c);
        }
        return c;
    }
}
