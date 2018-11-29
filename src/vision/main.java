package vision;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.highgui.Highgui;
import org.opencv.objdetect.CascadeClassifier;
 
class DetectFaceDemo {
public void run() {
System.out.println("nOpenCV en java");
 
CascadeClassifier faceDetector = new CascadeClassifier("C:\\Users\\HP\\eclipse-workspace\\RicardoMazzei\\resourse\\haarcascade_frontalface_default.xml");
Mat image = Highgui.imread("C:\\Users\\HP\\eclipse-workspace\\RicardoMazzei\\resourse\\cara2.jpg");
Mat image1 = Highgui.imread("C:\\Users\\HP\\eclipse-workspace\\RicardoMazzei\\resourse\\cara1.jpg");
Mat image2 = Highgui.imread("C:\\Users\\HP\\eclipse-workspace\\RicardoMazzei\\resourse\\cara3.jpg");

 
MatOfRect faceDetections = new MatOfRect();
faceDetector.detectMultiScale(image, faceDetections);

MatOfRect faceDetections1 = new MatOfRect();
faceDetector.detectMultiScale(image1, faceDetections1);

MatOfRect faceDetections2 = new MatOfRect();
faceDetector.detectMultiScale(image2, faceDetections2);
 
System.out.println(String.format("Rostros detectados: %s", faceDetections.toArray().length));
System.out.println(String.format("Rostros detectados: %s", faceDetections1.toArray().length));
System.out.println(String.format("Rostros detectados: %s", faceDetections2.toArray().length));

for (Rect rect : faceDetections.toArray()) {
Core.rectangle(image, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height), new Scalar(0, 255, 0));
}

for (Rect rect : faceDetections1.toArray()) {
Core.rectangle(image1, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height), new Scalar(0, 255, 0));
}
for (Rect rect : faceDetections2.toArray()) {
Core.rectangle(image2, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height), new Scalar(0, 255, 0));
}
 
String filename = "ImagenConRostros1.jpg";
System.out.println(String.format("Guardando Imagen 1 %s", filename));
Highgui.imwrite(filename, image);

String filename1 = "ImagenConRostros2.jpg";
System.out.println(String.format("Guardando Imagen 2 %s", filename1));
Highgui.imwrite(filename1, image1);

String filename2 = "ImagenConRostros3.jpg";
System.out.println(String.format("Guardando Imagen 3 %s", filename2));
Highgui.imwrite(filename2, image2);
}
}

public class main {
public static void main(String[] args){
System.loadLibrary("opencv_java2413");
new DetectFaceDemo().run();
}
}
