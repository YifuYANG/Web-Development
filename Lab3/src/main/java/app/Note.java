package app;



import java.util.Date;


public class Note
{

    private String title;
    private String note;
    private Date dateCreated;
    private Date dateEdited;

    public Note(String title,String note)
    {
        this.title=title;
        this.note=note;
    }


    public String getTitle()
    {
        return title;
    }

    public String getNote()
    {
        return note;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setNote(String note)
    {
        this.note = note;
    }

    public Date getDateCreated()
    {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated)
    {
        this.dateCreated = dateCreated;
    }

    public Date getDateEdited()
    {
        return dateEdited;
    }

    public void setDateEdited(Date dateEdited)
    {
        this.dateEdited = dateEdited;
    }
}
