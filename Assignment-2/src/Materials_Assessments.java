import java.util.ArrayList;

public interface Materials_Assessments {
    default void view_lecture_material(ArrayList<Class_Content> Materials){
        if (Materials.isEmpty() || Materials.size()==0){
            System.out.println("No Lecture Material Found");
            return;
        }
        for (Class_Content material:Materials){
            if(material.getMaterial().get(0).equals("Slide")){
                material.display_slide();
            }
            else if(material.getMaterial().get(0).equals("Video")){
                material.display_video();
            }
        }
    }
    default void view_assessments(ArrayList<Class_Content> Assessments){
        if (Assessments.isEmpty() || Assessments.size()==0){
            System.out.println("No Assessments Found");
            return;
        }
        int i=0;
        for (Class_Content assessment:Assessments){
            System.out.print("ID:"+i+", Status: "+assessment.getAssessment().get(3)+", ");
            i++;
            if (assessment.getAssessment().get(0).equals("Assignment")){
                assessment.display_Assignment();
            }
            else if (assessment.getAssessment().get(0).equals("Quiz")){
                assessment.display_Quiz();
            }
        }
    }
}
