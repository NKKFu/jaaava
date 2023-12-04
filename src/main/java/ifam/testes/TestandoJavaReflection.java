package ifam.testes;

import java.lang.reflect.*;

public class TestandoJavaReflection {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        String nomeDoPacote = "ifam.model";
        String nomeDaClasse = "Cidade";

        String nomeCompletoDaClasse = nomeDoPacote+"."+nomeDaClasse;

        Class<?> classe = Class.forName(nomeCompletoDaClasse);

        // Classe

        System.out.println("Nome da Classe: "+classe.getCanonicalName());

        int modificadoresDaClasse = classe.getModifiers();

        System.out.println("Modificador da Classe:"+Modifier.toString(modificadoresDaClasse));

        // Atributos

        //Obtendo os atributos da classe

        System.out.println("*** ATRIBUTOS ***");

        Field[] atributos = classe.getDeclaredFields();

        for(Field atributo: atributos){
            // mostrando os dados de cada atributo
            System.out.print(Modifier.toString(atributo.getModifiers())+" ");
            System.out.print(atributo.getGenericType().getTypeName()+" ");
            System.out.println(atributo.getName());
        }

        //Obtendo os metodos

        System.out.println("*** METODOS ***");

        Method[] metodos = classe.getDeclaredMethods();

        for(Method metodo: metodos){
            // mostrando os dados de cada atributo
            System.out.print(Modifier.toString(metodo.getModifiers())+" ");
            System.out.print(metodo.getReturnType().getTypeName()+" ");
            System.out.print(metodo.getName());
            System.out.print(" ( ");

            Parameter[] parametros = metodo.getParameters();

            for(Parameter parametro: parametros){
                System.out.print(parametro.getType().getTypeName()+" ");
                System.out.print(parametro.getName());
            }

            System.out.println(" ) ");

            //Invocação de Métodos

            // Método setNome
            // public void setNome(String nome)

            Class<?>[] parametrosSetNome = {String.class};

            Method setNome = classe.getMethod("setNome",parametrosSetNome);

            Object[] valoresSetNome = {"Manaus"};

            //Criar um objeto da classe em tempo de execução

            Object objetoCidade = classe.getDeclaredConstructor().newInstance();

            setNome.invoke(objetoCidade,valoresSetNome);

            // Método getNome
            // public String getNome()

            Class<?>[] parametrosGetNome = {};

            Method getNome = classe.getMethod("getNome",parametrosGetNome);

            Object[] valoresGetNome = {};

            //Criar um objeto da classe em tempo de execução

            //Usar o mesmo objeto cidade criado anteriormente para conseguir obter o valor da cidade.

            Object retorno = getNome.invoke(objetoCidade,valoresGetNome);

            System.out.println("Nome da Cidade:"+retorno);

        }

        // Now for class Estado
        System.out.println("--- Now for class Estado ---");
        nomeDaClasse = "Estado";
        nomeCompletoDaClasse = nomeDoPacote+"."+nomeDaClasse;
        classe = Class.forName(nomeCompletoDaClasse);

        // Classe
        System.out.println("Nome da Classe: "+classe.getCanonicalName());
        modificadoresDaClasse = classe.getModifiers();

        System.out.println("Modificador da Classe:"+Modifier.toString(modificadoresDaClasse));

        // Atributos
        System.out.println("*** ATRIBUTOS ***");
        atributos = classe.getDeclaredFields();
        for(Field atributo: atributos){
            // mostrando os dados de cada atributo
            System.out.print(Modifier.toString(atributo.getModifiers())+" ");
            System.out.print(atributo.getGenericType().getTypeName()+" ");
            System.out.println(atributo.getName());
        }
    }

}
