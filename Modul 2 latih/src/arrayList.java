import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) {
        // membuat objek Hewan
        List<String> Hewan = new ArrayList<>();
        Hewan.add("Sapi");
        Hewan.add("Kelinci");
        Hewan.add("Kambing");
        Hewan.add("Unta");
        Hewan.add("Domba");

        // membuat objek DeleteHewan
        List<String> deleteHewan = new ArrayList<>();
        deleteHewan.add("Kelinci");
        deleteHewan.add("Kambing");
        deleteHewan.add("Unta");
        
        // menghapus data yang sama dengan objek DeleteHewan
        Hewan.removeAll(deleteHewan);
        System.out.println("Output Hewan :");
        for (String h : Hewan){
            System.out.println(h);
        }

    }
}

