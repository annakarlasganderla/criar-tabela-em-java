package Model;

public class Produto {

    private int id;
    private String nome;
    private Double price;

    public Produto(int id, String nome, Double price) {
        this.id = id;
        this.nome = nome;
        this.price = price;
    }

    public Produto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return " Produto{" +
                " id -> " + id + " | " +
                " nome -> '" + nome + " | " +
                " price -> " + price +
                '}' + "\n";
    }
}
