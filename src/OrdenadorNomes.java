import java.util.*;

public class OrdenadorNomes {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("== Parte 1 ==");
        System.out.print("Informe nome(s) na mesma linha separado(s) por ,: ");
        String[] nomes = sc.nextLine().split(",");
        ordenarNomes(nomes);

        System.out.println("== Parte 2 ==");
        System.out.print("Informe nome(s) e sexo na mesma linha separados por - e , (Ex: Fabricio-M,Ana-F): ");
        String[] todosNomes = sc.nextLine().split(",");
        List<String> homens = new ArrayList<>();
        List<String> mulheres = new ArrayList<>();
        Map<String,List<String>> mapaSexo = new HashMap<>();
        separarPorSexo(todosNomes, homens, mulheres, mapaSexo);

        System.out.println("Homens");
        System.out.println(mapaSexo.get("Homens"));
        System.out.println("Mulheres");
        System.out.println(mapaSexo.get("Mulheres"));

    }

    public static void ordenarNomes(String[] nomes) {
        Arrays.sort(nomes);

        for (String s : nomes) {
            System.out.println(s);
        }
    }

    public static void separarPorSexo(String[] lista, List<String> masculino, List<String> feminino, Map<String,List<String>> mapaSexo) {
        for (String s : lista) {
            String[] token = s.split("-");
            if (token[1].equalsIgnoreCase("M")) {
                masculino.add(token[0]);
            } else if (token[1].equalsIgnoreCase("F")) {
                feminino.add(token[0]);
            }

            mapaSexo.put("Homens", masculino);
            mapaSexo.put("Mulheres", feminino);
        }
    }
}
