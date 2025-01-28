import java.util.Random;
import java.util.Scanner;
public class Marks{
public static void main(String[] args){
Scanner scanner=new Scanner(System.in);
System.out.print("Enter number of students: ");
int numStudents=scanner.nextInt();
int[][] scores=generateScores(numStudents);
Object[][] results=calculateResults(scores,numStudents);
displayScorecard(results,scores,numStudents);
}
public static int[][] generateScores(int numStudents){
Random random=new Random();
int[][] scores=new int[numStudents][3];
for(int i=0;i<numStudents;i++){
scores[i][0]=random.nextInt(100)+1;
scores[i][1]=random.nextInt(100)+1;
scores[i][2]=random.nextInt(100)+1;
}
return scores;
}
public static Object[][] calculateResults(int[][] scores,int numStudents){
Object[][] results=new Object[numStudents][5];
for(int i=0;i<numStudents;i++){
int total=scores[i][0]+scores[i][1]+scores[i][2];
double average=total/3.0;
double percentage=(total/3.0);
results[i][0]=total;
results[i][1]=Math.round(average*100.0)/100.0;
results[i][2]=Math.round(percentage*100.0)/100.0;
String remark;
if(percentage>=80){
remark="Level: 4 and Remark: Above agency-normalized standards";
}else if(percentage>=70&&percentage<=79){
remark="Level: 3 and Remark: at agency-normalized standards";
}else if(percentage>=60&&percentage<=69){
remark="Level: 2 and Remark: Below but approaching agency-normalized standards";
}else if(percentage>=50&&percentage<=59){
remark="Level: 1 and Remark: well below agency-normalized standards";
}else if(percentage>=40&&percentage<=49){
remark="Level: 1- and Remark: too below agency-normalized standards";
}else{
remark="Level: 4 and Remark: remedial standards";
}
results[i][3]=remark;
}
return results;
}
public static void displayScorecard(Object[][] results,int[][] scores,int numStudents){
System.out.println("Student\tPhysics\tChemistry\tMaths\tTotal\tAverage\tPercentage\tRemark");
for(int i=0;i<numStudents;i++){
System.out.printf("%d\t%d\t%d\t%d\t%d\t%.2f\t%.2f\t%s\n",i+1,scores[i][0],scores[i][1],scores[i][2],
(int)results[i][0],results[i][1],results[i][2],results[i][3]);
}
}
}

