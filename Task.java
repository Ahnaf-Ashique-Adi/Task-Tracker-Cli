import java.time.LocalDateTime;

class Task
{
    private int id;
    public String description;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    Task(int id,String description)
    {
        this.id=setId(id);
        this.description=setDescription(description);
        


    }
    public int getId() {
        return id;
    }
    public int setId(int id) {
        this.id = id;
        return id;
    }
    public String getDescription()
    {
        return description;

    }
    public String setDescription(String st)
    {
        this.description=st;
        return description;

    }

}