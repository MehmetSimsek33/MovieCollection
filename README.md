# Film Koleksiyonu 

![(/assets/images/shiprock.jpg)](https://bilgikenti.net/wp-content/uploads/2021/01/film3.jpg)
#  Uygulama özellikleri:
* Film Tanımı ( Ad, Yayın Yılı, Tür, Açıklama, Medya, Dil seçenekleri ) 
* Bir film için n tane Oyuncu tanımı yapılabilmeli ( Ad Soyad, isteğe
bağlı rol ) 
* Film Adı, Oyuncu Adı, Tür ile arama yapılabilmeli, yıla göre sıralama
yapılabilmeli
* Var olan bir kayıt üzerinde değişiklik yapılabilmeli 
* Var olan kayıtlar incelebilmeli
* Var olan bir kayıt silinebilmeli
*  Kod standartlarına uygun yazılım geliştirimesi
* Birim test içermesi 
* Kullanıcılar sisteme kullanıcı adı/parola ile giriş yapmalı

# Uygulamada Kullanılan Yazılım Dili ve Teknolojiler
* Java
* JavaScript
* Spring Boot
* Thymeleaf
* JPA
* Maven
* Bootstrap
* Lombok
* PostgreSQL

# Uygulamayı Çalıştırabilmek İçin Gereksinimler ve Uygulanılacak Adımlar
* JDK kurulmalıdır. Spring Boot için minimum 1.8 ve sonrası sürümler kurulmalıdır. 
* Lombok kurulmalıdır
* Veritabanı sunucusu kurulmalıdır
* Yukarıdaki kurulumlar tamamlandıktan sonra kurulmuş olan IDE (STS, Eclipse vb.) açılarak spring-library-application projesi import edilir.
* Projeyi Eclipse'de açtıktan sonra application.properties kısmında bu kodları yapıştırınız. username ve password kısmını siz Vertabanınızı yüklerken belirliyorsunuz ona göre değişim yapabilirsiniz. Ardından kaydediyorsunuz.

```
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.hibernate.show-sql=true
spring.datasource.url=jdbc:postgresql://localhost:5432/MovieCollection
spring.datasource.username=postgres
spring.datasource.password=635263
spring.jpa.properties.javax.persistence.validation.mode = none
logging.level.org.hibernate.SQL=DEBUG
logging.level.org.hibernate.type=TRACE
```
* # Giriş Sayfası
![](https://i.hizliresim.com/dqqs5d6.jpg)

* # Kayıt Ol
![](https://i.hizliresim.com/7qjjkt0.jpg)
* # Anasayfa
![](https://i.hizliresim.com/j24pmkn.jpg)
* # Actor Listesi
![](https://i.hizliresim.com/1eswewt.jpg)
* # Film Ekle
![](https://i.hizliresim.com/1mqit4i.jpg)
* # Actor Ekle
![](https://i.hizliresim.com/dym8c9x.jpg)
* # Film Güncelle
![](https://i.hizliresim.com/7d3mv2a.jpg)
* # Film Arama
![](https://i.hizliresim.com/3svf10h.jpg)

