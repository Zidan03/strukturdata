

public class Motor<E> {
    private final E element;

    public Motor (E mtr){
        element = mtr;
    }
    public E getElement(){
        return element;
    }
    public static void main(String[] args){
        Motor<Integer> jumlahMotor = new Motor<>(9);
        Motor<String> namaMotor = new Motor<>("Malang");
        System.out.println("Jumlah Motor di Jawa Timur : "+ jumlahMotor.getElement() + "kota");
        System.out.println("Salah Satu Motor yang paling banyak di Jawa Timur : Motor "+ namaMotor.getElement());
    }
}
