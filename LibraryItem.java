package librarymanagement;
public abstract class LibraryItem {
    private String title;
    private String author;
    private String category;
    private boolean checkedOut;

    public LibraryItem(String title, String author, String category) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.checkedOut = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Category: " + category + ", Checked Out: " + checkedOut;
    }
}
