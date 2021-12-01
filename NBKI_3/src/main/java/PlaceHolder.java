public class PlaceHolder {

    private PlaceHolder() {
    }

    public static String replace(String firstPlaceHolder, String secondPlaceHolder, String thirdPlaceHolder,
                                  int firstNumberIsMultiple, int secondNumberIsMultiple, int from, int to) {
        StringBuilder sb = new StringBuilder();
        // если условия цикла некорректны выкинем исключение
        if (from >= to)
            throw new CycleConditionsException();
        
        for (int i = from; i <= to; i++) {
            if (i % firstNumberIsMultiple == 0) {
                if (i % firstNumberIsMultiple == 0 && i % secondNumberIsMultiple == 0) {
                    sb.append(thirdPlaceHolder).append("\n");
                    continue;
                }
                sb.append(firstPlaceHolder).append("\n");
                continue;
            }
            if (i % secondNumberIsMultiple == 0) {
                sb.append(secondPlaceHolder).append("\n");
                continue;
            }
            sb.append(i).append("\n");
        }
        return sb.toString();
    }

    public static class CycleConditionsException extends RuntimeException {
        public CycleConditionsException() {
            super("The cycle conditions are incorrect: (from >= to).");
        }
    }
}
