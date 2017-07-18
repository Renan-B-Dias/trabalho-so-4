/**
 * Created by yellow-umbrella on 17/07/17.
 */
public class PageTable {

    protected Frame[] frames;

    public PageTable(int pagesProc) {
        frames = new Frame[pagesProc];
        for(Frame x: frames)
            x = new Frame();
    }

}
