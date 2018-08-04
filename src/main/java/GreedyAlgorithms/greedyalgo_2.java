package GreedyAlgorithms;

import java.util.*;

/**
 * Created by GAURAV on 8/3/2018.
 */
public class greedyalgo_2 {
    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        List<Meeting> meetingList;
        while (testCases-- > 0) {
            int meetings = sc.nextInt();
            int temp = meetings;
            int[] startTimeArr = new int[meetings];
            int[] endTimeArr = new int[meetings];
            int count = 0;
            meetingList = new ArrayList<>();
            while (meetings-- > 0) {
                startTimeArr[count++] = sc.nextInt();
            }
            meetings = temp;
            count = 0;
            while (meetings-- > 0) {
                endTimeArr[count++] = sc.nextInt();
            }*/
        List<Meeting> meetingList = new ArrayList<>();
        int[] startTimeArr = new int[]{75250, 50074, 43659, 8931, 11273, 27545, 50879, 77924};
        int[] endTimeArr = new int[]{112960, 114515, 81825, 93424, 54316, 35533, 73383, 160252};
        for (int i = 0; i < startTimeArr.length; i++) {
            meetingList.add(new Meeting(i + 1, startTimeArr[i], endTimeArr[i]));
        }
        Collections.sort(meetingList);
        System.out.print(meetingList.get(0).getMeetingSequence() + " ");
        int endTime = meetingList.get(0).getEndTime();
        for (Meeting meeting : meetingList) {
            if (meeting.getStartTime() > endTime) {
                System.out.print(meeting.getMeetingSequence() + " ");
                endTime = meeting.getEndTime();
            }
        }
        System.out.println("");
    }
}


class Meeting implements Comparable<Meeting> {

    private int startTime;
    private int endTime;
    private int meetingSequence;

    public Meeting(int meetingSequence, int startTime, int endTime) {
        this.meetingSequence = meetingSequence;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public int getMeetingSequence() {
        return meetingSequence;
    }

    @Override
    public int compareTo(Meeting meeting2) {
        return this.endTime - meeting2.endTime;
    }
}

class MeetingComparator implements Comparator<Meeting> {
    @Override
    public int compare(Meeting meeting1, Meeting meeting2) {
        return meeting1.getEndTime() - meeting2.getEndTime();
    }
}
