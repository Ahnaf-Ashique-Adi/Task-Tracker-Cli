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
        this.status="To do";
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

}