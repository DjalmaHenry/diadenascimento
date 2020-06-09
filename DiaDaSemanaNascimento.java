package diadasemananascimento;

import java.util.Scanner;

public class DiaDaSemanaNascimento {

    public static boolean verificaBissexto(int ano) {
        boolean verificado;
        if (ano % 4 == 0 && ano % 100 != 0) {
            verificado = true;
        } else {
            verificado = false;
        }
        return verificado;
    }

    public static boolean verificaData(int dia, int mes, int ano) {
        boolean verificado, bissexto, verificaAno = true, verificaMes = true,
                verificaDia = true;
        if (ano >= 1900 && ano <= 2399) {
            verificaAno = true;
        } else {
            verificaAno = false;
        }
        if (mes >= 1 && mes <= 12) {
            verificaMes = true;
        } else {
            verificaMes = false;
        }
        if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
            if (dia > 30) {
                verificaDia = false;
            } else {
                verificaDia = true;
            }
        } else {
            verificaDia = true;
        }
        bissexto = verificaBissexto(ano);
        if (bissexto == false && mes == 2) {
            if (dia > 28) {
                verificaDia = false;
            } else {
                verificaDia = true;
            }
        }
        if (bissexto == true && mes == 2) {
            if (dia > 29) {
                verificaDia = false;
            } else {
                verificaDia = true;
            }
        }
        if (verificaDia == true && verificaMes == true && verificaAno == true) {
            verificado = true;
        } else {
            verificado = false;
        }
        return verificado;
    }

    public static int verificaDiaDaSemana(int dia, int mes, int ano) {
        int a, b, c, d, soma, verificado;
        boolean bissexto;
        a = ano - 1900;
        b = a / 4;
        bissexto = verificaBissexto(ano);
        if (bissexto == true && mes <= 2) {
            b--;
        }
        if (mes == 1 || mes == 10) {
            c = 0;
        } else if (mes == 5) {
            c = 1;
        } else if (mes == 8) {
            c = 2;
        } else if (mes == 2 || mes == 3 || mes == 11) {
            c = 3;
        } else if (mes == 6) {
            c = 4;
        } else if (mes == 9 || mes == 12) {
            c = 5;
        } else {
            c = 6;
        }
        d = dia - 1;
        soma = a + b + c + d;
        verificado = soma % 7;
        return verificado;
    }

    public static String nomeMes(int mes) {
        String nome = "null";
        switch (mes) {
            case 1:
                nome = "janeiro";
                break;
            case 2:
                nome = "fevereiro";
                break;
            case 3:
                nome = "março";
                break;
            case 4:
                nome = "abril";
                break;
            case 5:
                nome = "maio";
                break;
            case 6:
                nome = "junho";
                break;
            case 7:
                nome = "julho";
                break;
            case 8:
                nome = "agosto";
                break;
            case 9:
                nome = "setembro";
                break;
            case 10:
                nome = "outubro";
                break;
            case 11:
                nome = "novembro";
                break;
            case 12:
                nome = "dezembro";
                break;
        }
        return nome;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int dia, mes, ano, diaSemana;
        boolean bissexto, data;
        String nomeM;
        char loop;
        do {
            System.out.println("Vamos descobrir que dia da semana você"
                    + " nasceu!");
            System.out.print("Informe o Dia: ");
            dia = input.nextInt();
            input.nextLine();
            System.out.print("Informe o Mês(número): ");
            mes = input.nextInt();
            input.nextLine();
            System.out.print("Informe o Ano: ");
            ano = input.nextInt();
            input.nextLine();
            bissexto = verificaBissexto(ano);
            data = verificaData(dia, mes, ano);
            while (data == false) {
                System.out.println("Erro, informe uma data válida.");
                System.out.print("Informe o Dia: ");
                dia = input.nextInt();
                input.nextLine();
                System.out.print("Informe o Mês(número): ");
                mes = input.nextInt();
                input.nextLine();
                System.out.print("Informe o Ano: ");
                ano = input.nextInt();
                input.nextLine();
                bissexto = verificaBissexto(ano);
                data = verificaData(dia, mes, ano);
            }
            diaSemana = verificaDiaDaSemana(dia, mes, ano);
            nomeM = nomeMes(mes);
            switch (diaSemana) {
                case 0:
                    System.out.println("Você nasceu em " + dia + " de " + nomeM
                            + " de " + ano + ". Esta data foi uma "
                            + "segunda-feira.");
                    break;
                case 1:
                    System.out.println("Você nasceu em " + dia + " de " + nomeM
                            + " de " + ano + ". Esta data foi uma "
                            + "terça-feira.");
                    break;
                case 2:
                    System.out.println("Você nasceu em " + dia + " de " + nomeM
                            + " de " + ano + ". Esta data foi uma "
                            + "quarta-feira.");
                    break;
                case 3:
                    System.out.println("Você nasceu em " + dia + " de " + nomeM
                            + " de " + ano + ". Esta data foi uma "
                            + "quinta-feira.");
                    break;
                case 4:
                    System.out.println("Você nasceu em " + dia + " de " + nomeM
                            + " de " + ano + ". Esta data foi uma "
                            + "sexta-feira.");
                    break;
                case 5:
                    System.out.println("Você nasceu em " + dia + " de " + nomeM
                            + " de " + ano + ". Esta data foi um sábado.");
                    break;
                default:
                    System.out.println("Você nasceu em " + dia + " de " + nomeM
                            + " de " + ano + ". Esta data foi um domingo.");
                    break;
            }
            System.out.print("Deseja fazer mais uma consulta? Digite S ou N: ");
            loop = input.next().charAt(0);
            input.nextLine();
            loop = Character.toUpperCase(loop);
            while (loop != 'S' && loop != 'N') {
                System.out.println("Erro, informe um valor válido.");
                System.out.print("Deseja fazer mais uma consulta? Digite S ou "
                        + "N: ");
                loop = input.next().charAt(0);
                input.nextLine();
                loop = Character.toUpperCase(loop);
            }
        } while (loop == 'S');
    }
}