package Elements;

public class ScreenScripts {
    public static void PullNotebookPageToTextBox(){
        GraphicsDatabase.I02.setContents(DataCache.myShip.myNotebook().entries().get(DataCache.pageNumber).name());
        GraphicsDatabase.I03.setContents(DataCache.myShip.myNotebook().entries().get(DataCache.pageNumber).entry());

    }
}
