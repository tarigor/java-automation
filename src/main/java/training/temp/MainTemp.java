package training.temp;

import java.io.File;
import java.util.ArrayList;

public class MainTemp {
    public static void main(String[] args) {
        String path = "c:/test";
        File file = new File(path);
        String tab="";
        pathPrint(file,tab);
    }

    private static void pathPrint(File file, String tab) {
        File fileOrFolder[] = file.listFiles();
//        fileSort(fileOrFolder);
//        if(fileOrFolder!=null){
//            for(int i=0;i<fileOrFolder.length;i++)
//                if(fileOrFolder[i].isDirectory()){
//                    System.out.println(tab+"|__"+fileOrFolder[i].getName());
//                    pathPrint(fileOrFolder[i],tab+"    ");
//                }else{
//                    System.out.println(tab+""+fileOrFolder[i].getName());
//                }
//        }
        if(fileSort(fileOrFolder).size()!=0){
            for(int i=0;i<fileSort(fileOrFolder).size();i++)
                if(((File) fileSort(fileOrFolder).get(i)).isDirectory()){
                    System.out.println(tab+"|__"+((File) fileSort(fileOrFolder).get(i)).getName());
                    pathPrint(((File) fileSort(fileOrFolder).get(i)).getParentFile(),tab+"    ");
                }else{
                    System.out.println(tab+""+((File) fileSort(fileOrFolder).get(i)).getName());
                }
        }
    }

    private static ArrayList fileSort(File[] fileOrFolder) {
        ArrayList arrayOfFolders = new ArrayList();
        ArrayList arrayOfFiles = new ArrayList();
        int indexOfFolder=0;
        int indexOfFile=0;
        for(int i=0;i<fileOrFolder.length;i++){
            if(fileOrFolder[i].isDirectory()){
                arrayOfFolders.add(indexOfFolder,fileOrFolder[i].getName());
                indexOfFolder++;
            }else{
                arrayOfFiles.add(indexOfFile,fileOrFolder[i]);
                indexOfFile++;
            }
        }
        for(int i=0;i<arrayOfFiles.size();i++){
            arrayOfFolders.add(indexOfFolder, ((File) arrayOfFiles.get(i)).getParentFile());
        }
        return arrayOfFolders;
//        System.out.println(arrayOfFolders);
    }
}
