/**
 * Created by yellow-umbrella on 17/07/17.
 */
public class PageTable {

    protected Frame[] frames;

    public PageTable(int pagesProc) {
        frames = new Frame[pagesProc];
        for(int i = 0; i < frames.length; i++)
            frames[i] = new Frame();
    }

    public int inMemory(int id) {
        for(int i = 0; i < frames.length; i++)
            if(frames[i].id == id)
                if(frames[i].valid == true)
                    return i;
                else
                    return -1;
        return -1; // Never should happen!!!
    }

    public Frame getFrame(int id) {
        for(int i = 0; i < frames.length; i++) {
            if(frames[i].id == id) {
                return frames[i];
            }
        }
        return null;
    }

    public void setBit(int index, boolean bool) {
        frames[index].valid = bool;
    }

}
