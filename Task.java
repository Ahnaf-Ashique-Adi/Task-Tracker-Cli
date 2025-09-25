import java.time.LocalDateTime;

class Task
{
    private int id;
    public String description;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
// This is the constructor for the TAsks
    Task(int id,String description)
    {
        this.id=id;
        this.description=description;
        this.status="to do";
        this.createdAt=LocalDateTime.now();
        this.updatedAt=this.createdAt;
    }
    //Getter methds 
    public int getId() {
        return id;
    }
    public String getDescription() {
        return description;
    }
    public String getStatus() {
        return status;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    //This are the setter methods 
    public void setDescription(String description)
    {
        this.description=description;
        this.updatedAt=LocalDateTime.now();
    }
    public void setStatus(String status)
    {
        this.status=status;
        this.updatedAt=LocalDateTime.now();
    }
    public void markInProgress()
    {
        setStatus("in-progress");
    }
    public void markDone()
    {
        setStatus("done");
    }
    public void reset()
    {
        setStatus("to do");
    }


}