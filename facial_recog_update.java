import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.features2d.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

import java.io.File;
import java.lang.*;
public class faceRecognition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        System.out.println("\nRunning FaceDetector");

        CascadeClassifier faceDetector = new CascadeClassifier("haarcascade_frontalface_alt.xml");
        if (faceDetector.empty()){
        	System.out.println("faceDetector empty");
        }
        else {	
        Mat image = Imgcodecs.imread("C:\\Users\\mishapetty\\Desktop\\Iphone Pix\\IMG_0551.jpg");
        
        MatOfRect faceDetections = new MatOfRect();
        faceDetector.detectMultiScale(image, faceDetections);
 
        System.out.println(String.format("Detected %s faces", faceDetections.toArray().length));
        
        for (Rect rectangle : faceDetections.toArray()) {
            Imgproc.rectangle(image, new Point(rectangle.x, rectangle.y), new Point(rectangle.x + rectangle.width, rectangle.y + rectangle.height),
                    new Scalar(0, 255, 0));
         }
 
        String filename = "ouput.png";
        System.out.println(String.format("Writing %s", filename));
        Imgcodecs.imwrite(filename, image);
        }
	}

}
