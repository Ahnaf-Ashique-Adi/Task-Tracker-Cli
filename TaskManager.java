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
     public void add(String description)
        { 
            int newId= size+1;
            Task newTask= new Task(newId, description);
            tasks[size]=newTask;
            size++;
            saveToFile();


        }
        public void Update(int id, String newDescription)
        {

        }
        public void Delete(int id)
        {

        }
        public void listTask()
        {

        }
        public void listDone()
        {

        }
        public void listNotDone()
        {

        }
        public void listInProgress()
        {

        }
        public void saveToFile()
        {
            try
            {
                FileWriter writer = new FileWriter(file);
                writer.write("[");
                for(int i=0;i<size)
                
            }
            catch (Exception e)
            {
                // TODO: handle exception
                System.out.println("Error"+e.getMessage());
            }
        }


    
}