package racing.view;

import racing.domain.RacingCar;
import racing.domain.RacingScore;
import racing.domain.WinnerRacingCars;
import racing.dto.RacingCarDto;

import java.util.List;
import java.util.Map;

public class ResultView {

    private ResultView() {}

    public static void titlePrint() {

        System.out.println("실행 결과");
    }

    public static void winnerPrint(final WinnerRacingCars winnerRacingCars) {

        System.out.printf("%s가 최종 우승했습니다.", pick(winnerRacingCars));
    }

    public static void resultPrint(final RacingScore racingScore) {

        totalResultPrint(racingScore.score());
    }

    private static void totalResultPrint(final Map<Integer, List<RacingCarDto>> score) {

        for (Integer integer : score.keySet()) {
            racingPrint(score.get(integer));
            ResultView.blank();
        }
    }

    private static void racingPrint(final List<RacingCarDto> racingCarDtos) {

        racingCarDtos.stream()
                .forEach(racingCar -> {
                    final String stringBuilder = racingCar.getName() +
                            " : " +
                            convert(racingCar.getPosition());
                    System.out.println(stringBuilder);
                });
    }

    private static void blank() {

        System.out.println();
    }

    public static String convert(final int position) {

        final StringBuilder result = new StringBuilder();
        for (int i = 0; i < position; i++) {
            result.append("-");
        }
        return result.toString();
    }

    public static String pick(final WinnerRacingCars winnerRacingCars) {

        final StringBuilder winner = new StringBuilder();
        int index = 1;
        for (RacingCar racingCar : winnerRacingCars.getWinnerRacingCars()) {
            winner.append(collect(index, racingCar, winnerRacingCars));
            index++;
        }
        return winner.toString();
    }

    private static String collect(final int index, final RacingCar racingCar, final WinnerRacingCars winnerRacingCars) {

        String carName = racingCar.getName().getName();
        if(index != winnerRacingCars.getWinnerRacingCars().size()) {
            carName += ",";
        }
        return carName;
    }
}
