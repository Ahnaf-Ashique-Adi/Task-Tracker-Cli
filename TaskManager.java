import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
class TaskManager
{
    //considering JSON as Array 
    private Task[] tasks;
    
    // ei variable ta comparision e help korbe  
    private int size;
    //file create 
    private File file ;

    TaskManager()
    {
        this.tasks=new Task[15];
        this.size=0;
        this.file=new File("tasks.json");
        
        try
        {
            if(!file.exists())//mane file nai taile
            {
                file.createNewFile();
                FileWriter writer=new FileWriter(file);
                writer.write("[]");//JSON Start and ENd 
                writer.close();
            }

        }
        catch(IOException e)
        {
            System.out.println("Error"+e.getMessage());
        }


    }


    
}