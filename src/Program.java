import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Program {

	public static void main(String[] args) {

		LocalDate localDate = LocalDate.now();
		System.out.println(localDate);
		
		LocalDate localDate3 = LocalDate.now().plusDays(1).plusMonths(1);
		System.out.println(localDate3);
		
		LocalDateTime time = LocalDateTime.now();
		System.out.println(time);
		
		LocalTime localTime = LocalTime.now();
		System.out.println(localTime);
		
		LocalDateTime time3 = LocalDateTime.now().plusDays(1).plusMonths(1).plusHours(1);
		System.out.println(time3);
		
		LocalDate localDate5 = LocalDate.of(2021, 07, 22);
		System.out.println(localDate5);
		
		LocalDateTime localDateTime5 = LocalDateTime.of(2018, 07, 22, 10, 15, 30);
		System.out.println(localDateTime5);
		
		LocalDate localDate6 = LocalDate.parse("2021-05-16", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		System.out.println(localDate6);
		
		int year = LocalDate.now().getYear();
		Month month = LocalDateTime.now().getMonth();
		int hour = LocalTime.now().getHour();
		System.out.println(year);
		System.out.println(month);
		System.out.println(hour);
		
		LocalDate localDate8 = LocalDate.of(2021, 05, 16);
		LocalDate localDate9 = LocalDate.now();
		
		boolean isAfter = localDate8.isAfter(localDate9);
		boolean isBefore = localDate8.isBefore(localDate9);
		boolean isEqual = localDate8.isEqual(localDate9);

		System.out.println(isAfter);
		System.out.println(isBefore);
		System.out.println(isEqual);
		
		/*
		 * Capturando diferenças entre LocalDate com a classe Period 
		 */
		LocalDate localDate10 = LocalDate.now();
		LocalDate localDate11 = LocalDate.of(1972, 11, 28);
		
		Period period1 = Period.between(localDate10, localDate11);
		System.out.println(period1);
		
		LocalDateTime localDateTime12 = LocalDateTime.now();
		LocalDateTime localDateTime13 = LocalDateTime.now().plusDays(2);
		
		long periodAsMinutes = ChronoUnit.MINUTES.between(localDateTime12, localDateTime13);
		System.out.println(periodAsMinutes);
		long periodAsHours = ChronoUnit.HOURS.between(localDateTime12, localDateTime13);
		System.out.println(periodAsHours);
		long periodAsDays = ChronoUnit.DAYS.between(localDateTime12, localDateTime13);
		System.out.println(periodAsDays);
		
		try {
			Files.lines(Paths.get("C:\\ambienteDeEstudoAds4\\exercicios\\file.csv"))
			.skip(1)
			.map(line-> line.split(";"))
			.map(col-> new User(col[0], col[1], Integer.parseInt(col[2]), col[3], col[4]))
			.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static class User {
		
		private String nome, cpf;
		private Integer age;
		private String phone, address;
		public User(String nome, String cpf, Integer age, String phone, String address) {
			super();
			this.nome = nome;
			this.cpf = cpf;
			this.age = age;
			this.phone = phone;
			this.address = address;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getCpf() {
			return cpf;
		}
		public void setCpf(String cpf) {
			this.cpf = cpf;
		}
		public Integer getAge() {
			return age;
		}
		public void setAge(Integer age) {
			this.age = age;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		@Override
		public String toString() {
			return "User [nome=" + nome + ", cpf=" + cpf + ", age=" + age + ", phone=" + phone + ", address=" + address
					+ "]";
		}
		
		
	}

}
