public class GenericCalculator<T> {
    private String result;
    public String calculateResult(T val1, T val2){
        try {
            result=(String.valueOf((Integer.parseInt(val1.toString()) / Integer.parseInt(val2.toString()))));
        }
        catch (Exception e){
            result=(String.valueOf(val1.toString() + val2.toString()));
        }
        System.out.println("Correct Answer is: "+result);
        return result;
    }
}
