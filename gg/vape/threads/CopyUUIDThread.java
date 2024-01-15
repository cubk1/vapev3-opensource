package gg.vape.threads;

import gg.vape.ui.click.actions.ActionCopyProfileUUID;

public class CopyUUIDThread extends Thread {
   // $FF: synthetic field
   final ActionCopyProfileUUID actionCopyProfileUUID;

   public CopyUUIDThread(ActionCopyProfileUUID action) {
      this.actionCopyProfileUUID = action;
   }

   public void run() {
      try {
         Thread.sleep(1000L);
      } catch (InterruptedException ex) {
         ex.printStackTrace();
      }

      this.actionCopyProfileUUID.c4862.setText("Copy profile UUID");
   }
}
