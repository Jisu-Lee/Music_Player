package Music;

import GUI.PlayerTab;

public class Lyric_Repeat extends Thread {
    private String showLyric;

    public Lyric_Repeat() {
        start();
    }

    public void run() {
        int min = 0;
        int sec = 0;
        int msec = 0;
        int total;
        // String showLyric;

        while (true) {
            Lyric_Parser b = new Lyric_Parser();
            Lyric c = new Lyric(b.getTime(), b.getLrc());
            if (b == null) continue;
            try {
                sleep(10);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            String currentMusicTime = CurrentMusic.getInstance().getCurrentTime().toString();
            if (!currentMusicTime.contains("empty")) {
                total = Integer.parseInt(currentMusicTime.substring(9, currentMusicTime.indexOf("."))) / 10;
                min = total / (60 * 100);
                sec = ((total - (min * 60) / 100 / 60) / 100) % 60;
                msec = total % 100;

            }
            PlayerTab.text.setText(c.lyricShow(min, sec, msec));
            PlayerTab.text.updateUI();
        }
    }

}
