package budget.actions;

public abstract class FileAction implements Action {
    protected final String fileName = "purchases.txt";
    protected final String pathName = "budget/files/";

    protected final String fullPathname = pathName + fileName;
}
