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
        public void update(int id, String newDescription)
        {
            for( int j = 0;j<this.size;j++)
            {
                if(tasks[j]!=null && tasks[j].getId()==id)
                {
                    tasks[j].setDescription(newDescription);
                    saveToFile();
                    System.out.println("Task Updated (ID: "+id+")");
                    return;

                }

            }
            System.out.println("Task not found (ID: "+id+")");


        }
        public void delete(int id)
        {

            for(int i=0;i<size;i++)
            {
                if(tasks[i]!=null && tasks[i].getId()==id)
                {
                    for(int j=i;j<size-1;j++)
                    {
                        tasks[j]=tasks[j+1];
                    }
                    tasks[size-1]=null;
                    size--;
                    System.out.println("Task deleted");
                    return;

                }

                
            }
            System.out.println("Task not found");


        }
        public void listTask()
        {
            if(size==0)
            {
                System.out.println("No tasks to list");
            }
            else
            {
                for(int i=0;i<size;i++)
            {
                System.out.println("ID: "+tasks[i].getId()+
                " | Description: "+tasks[i].getDescription()+
                " | Status: "     +tasks[i].getStatus()+
                " | CreatedAt: "  +tasks[i].getCreatedAt()+
                " | UpdatedAt: "  +tasks[i].getUpdatedAt());
                System.out.println("--------------------------------------");
            }

            }
            

        }
        public void listDone()
        {
            if(size==0)
            {
                System.out.println("Task not found");
            }
            else
            {
                for(int i=0;i<size;i++)
                {
                    if(tasks[i].getClass().equals("done"))
                    {
                        System.out.println("ID: "+tasks[i].getId()+
                        " | Description: "+tasks[i].getDescription()+
                        " | Status: "     +tasks[i].getStatus()+
                        " | CreatedAt: "  +tasks[i].getCreatedAt()+
                        " | UpdatedAt: "  +tasks[i].getUpdatedAt());
                        System.out.println("--------------------------------------");
                    }
                }
            }
          
        }
        public void listNotDone()
        {
            if(size==0)
            {
                System.out.println("Task not found");
            }
            else
            {
                for(int i=0;i<size;i++)
                {
                    if(tasks[i].getClass().equals("to do"))
                    {
                        System.out.println("ID: "+tasks[i].getId()+
                        " | Description: "+tasks[i].getDescription()+
                        " | Status: "     +tasks[i].getStatus()+
                        " | CreatedAt: "  +tasks[i].getCreatedAt()+
                        " | UpdatedAt: "  +tasks[i].getUpdatedAt());
                        System.out.println("--------------------------------------");
                    }
                }
            }

        }
        public void listInProgress()
        {
            if(size==0)
            {
                System.out.println("Task not found");
            }
            else
            {
                for(int i=0;i<size;i++)
                {
                    if(tasks[i].getClass().equals("in-progress"))
                    {
                        System.out.println("ID: "+tasks[i].getId()+
                        " | Description: "+tasks[i].getDescription()+
                        " | Status: "     +tasks[i].getStatus()+
                        " | CreatedAt: "  +tasks[i].getCreatedAt()+
                        " | UpdatedAt: "  +tasks[i].getUpdatedAt());
                        System.out.println("--------------------------------------");
                    }
                }
            }

        }
        public void saveToFile()
        {
            try
            {
                FileWriter writer = new FileWriter(file);
                writer.write("[");
                for(int i=0;i<size;i++)
                {
                    Task task= tasks[i];//access kortesi array theke task gula ke and raktesi task e 
                    //anar pore Json akare format korbo
                    String json ="{"
                    +"\"id\": "+task.getId()+", "
                    +"\"description\": \""+ task.getDescription()+"\","
                    + "\"status\": \"" + task.getStatus() + "\", "
                    + "\"createdAt\": \"" + task.getCreatedAt() + "\", "
                    + "\"updatedAt\": \"" + task.getUpdatedAt() + "\""
                    + "}";
                    writer.write(json);
                    if(i<size-1)
                    {
                        writer.write(",");
                    }

                }
                writer.write("]");
                writer.close();
                
            }
            catch (Exception e)
            {
                // TODO: handle exception
                System.out.println("Error"+e.getMessage());
            }
        }


    
}