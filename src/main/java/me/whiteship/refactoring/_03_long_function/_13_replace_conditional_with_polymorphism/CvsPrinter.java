package me.whiteship.refactoring._03_long_function._13_replace_conditional_with_polymorphism;

import java.io.IOException;
import java.util.List;

public class CvsPrinter extends StudyPrinter {

  public CvsPrinter(int totalNumberOfEvents,
      List<Participant> participants) {
    super(totalNumberOfEvents, participants);
  }

  public void execute() throws IOException {
    this.participants.forEach(p -> {
      System.out.printf("%s %s:%s\n", p.username(), checkMark(p), p.getRate(this.totalNumberOfEvents));
    });
  }

  private String getCvsForParticipant(Participant participant) {
    StringBuilder line = new StringBuilder();
    line.append(participant.username());
    for (int i = 1 ; i <= this.totalNumberOfEvents ; i++) {
      if(participant.homework().containsKey(i) && participant.homework().get(i)) {
        line.append(",O");
      } else {
        line.append(",X");
      }
    }
    line.append(",").append(participant.getRate(this.totalNumberOfEvents));
    return line.toString();
  }

  private String cvsHeader(int totalNumberOfParticipants) {
    StringBuilder header = new StringBuilder(String.format("참여자 (%d),", totalNumberOfParticipants));
    for (int index = 1; index <= this.totalNumberOfEvents; index++) {
      header.append(String.format("%d주차,", index));
    }
    header.append("참석율");
    return header.toString();
  }
}
