
# GoArt Case

Bu proje GoArt tarafından iletilen API servisi için yazılmış bir Java Maven test otomasyon projesidir. Bu projede amaç, API uçlarının olası tüm test senaryolarının otomatize edilmesidir.

## Api Hakkında
API uçları ve aldıkları parametreler hakkında gerekli bilgiler aşağıda verilmiştir. İlgili uca ait test senaryoları açıklanmıştır.

Tüm senaryolar için Postman ile ;

- 1- Status Code kontrolü
- 2- Content Type header kontrolü
- 3- Content Type application/json; charset=utf-8 kontrolü
- 4- Key data type kontrolü
- 5- Response time kontrolü

ve uç özelinde aşağıdaki testlerin kontrolü sağlanmıştır.

Postman ile yapılan proje detaylarına aşağıdaki linkten erişilebilir.
- https://www.postman.com/payload-astronomer-91443209/workspace/sanemkara/overview

Java ile yapılan projenin test senaryolarında, test senaryosunun hangi test methodunda gerçekleştirildiği açıklanmıştır.

## Create User 
### |  POST      | ....../users 
| **Request**    | **Tip**  | **Açıklama**    |------------------------------------------------------------|**Response**      | **Tip (Dict)**  | **Açıklama**    | 
| :--------      | :------- | :-------------- |:---------------------------------------------------------- |:---------------- | :-------------- | :-------------- | 
| `firstName`    | `String` | *Adı*           |                                                            | `userId`         | `guid`          | *Kullanıcı Id*  | 
| `lastName`     | `String` | *Soyadı*        |                                                            |                  |                 |                 |              
| `username`     | `String` | *Kullanıcı Adı* |                                                            |                  |                 |                 | 
| `password`     | `String` | *Şifre*         |                                                            |                  |                 |                 |  

```
1- Örnek body ile kullanıcının oluştuğunun doğrulanması
```
- src/test/java/tests/happyPathCases/BaseTests.java --> postCreateUserTest() 
- --> src/test/java/methods/EndpointsVerifyMethods.java --> verifyGetUserById()
```
2- Her istekte yeni bir kullanıcı id oluşması        
```
- Mock Api olması sebebiyle her istekte aynı id ile cevap dönmektedir.
```
3- Body parametresi olmadan kullanıcı oluşmaması 
```
- src/test/java/tests/negativeCases/BlankBodyTests.java --> postCreateUserTest() 
- --> src/test/java/methods/EndpointsVerifyMethods.java --> verifyPostCreateUser()
```
4- Body parametresine String içinde karakterler gönderildiğinde kullanıcı oluşmaması
```
- src/test/java/tests/negativeCases/CharacterBodyTests.java --> postCreateUserTest() 
- --> src/test/java/methods/EndpointsVerifyMethods.java --> verifyPostCreateUser()

## Get User List
### | GET        | ... /users 
| **Request**    | **Tip**  | **Açıklama**    |---------------------------------------------------------------------|**Response**      | **Tip (List)**  | **Açıklama**    | 
| :--------      | :------- | :-------------- |:--------------------------------------------------------------------|:---------------- | :-------------- | :-------------- | 
|                |          |                 |                                                                     | `id`             | `guid`          | *Kullanıcı Id*  | 
|                |          |                 |                                                                     | `username `      | `String`        | *Kullanıcı Adı* |                       
|                |          |                 |                                                                     | `firstName`      | `String`        | *Adı*           | 
|                |          |                 |                                                                     | `flastName`      | `String`        | *Soyadı*        |
|                |          |                 |                                                                     | `isActive`       | `Booelan`       | *Durum*         |

```
1- Kullanıcı listesinin döndüğünün doğrulanması
```
- src/test/java/tests/happyPathCases/BaseTests.java --> getUserListTest()
- Bu uç diğer testlerde doğrulama yöntemi olarak kullanılmaktadır. Bir api ucunu diğer bir api ucu ile doğrulamanın tehlikesinin bilincinde olarak gönderilen api yapısına tek uygun doğrulama yönteminin bu olması sebebiyle bu şekilde yapılmıştır.

## Get User By Id
### | GET        | ... /users/[guid] 
| **Request**    | **Tip**  | **Açıklama**    |--------------------------------------------------------------------|**Response**      | **Tip (Dict)**  | **Açıklama**    | 
| :--------      | :------- | :-------------- |:-------------------------------------------------------------------|:---------------- | :-------------- | :-------------- | 
|                |          |                 |                                                                    | `id`             | `guid`          | *Kullanıcı Id*  | 
|                |          |                 |                                                                    | `username `      | `String`        | *Kullanıcı Adı* |                       
|                |          |                 |                                                                    | `firstName`      | `String`        | *Adı*           | 
|                |          |                 |                                                                    | `flastName`      | `String`        | *Soyadı*        |
|                |          |                 |                                                                    | `isActive`       | `Booelan`       | *Durum*         |

```
1- Örnek id ile kullanıcı bilgilerinin doğrulanması
```
- src/test/java/tests/happyPathCases/BaseTests.java --> getUserById() 
```
2- getUserList ucu ile alınan diğer id ile kullanıcı bilgilerinin doğrulanması
```
- src/test/java/tests/happyPathCases/BaseId2Tests.java --> getUserById() 
```
3- Boş id değeri ("") ile status code 200 dönmemesi       
```
- src/test/java/tests/negativeCases/GuidBlankTests.java --> blankGuidGetUserById()
- !!! Burada boş id ile kullanıcı listesini getiren uca istek atılmaktadır.
```
4- Boşluk id değeri (" ") ile status code 200 dönmemesi       
```
- src/test/java/tests/negativeCases/GuidSpaceTests.java --> spaceGuidGetUserById()
- !!! Burada boş id ile kullanıcı listesini getiren uca istek atılmaktadır.
```
5- Karakter guid değeri ("?!'^+%&/") ile status code 200 dönmemesi       
```
- src/test/java/tests/negativeCases/GuidCharacterTests.java --> characterGuidGetUserById()
```
6- Doğru guid formatı fakat karakter ("!!!!!!!!-!!!!-!!!!-!!!!-!!!!!!!!!!!!") ile status code 200 dönmemesi       
```
- src/test/java/tests/negativeCases/GuidFormatButCharacterTests.java --> formatCharacterGuidGetUserById()
```
7- Guid formatı sınır rakamlar ("99999999-9999-9999-9999-999999999999") ile status code 200 dönmemesi       
```
- src/test/java/tests/negativeCases/GuidNineTests.java --> nineGuidGetUserById()
- Burada sadece 2 kullanıcı olduğu bilindiğinden bu test senaryosu yazılmıştır.
```
8- Guid formatı sınır rakamlar ("00000000-0000-0000-0000-000000000000") ile status code 200 dönmemesi       
```
- src/test/java/tests/negativeCases/GuidZeroTests.java --> zeroGuidGetUserById()
- Buradaki test senaryosunun hatası ile daha önce karşılaşıldığı için yazılmıştır.


## Remove User
### | DELETE     | ... /users/[guid] 
| **Request**    | **Tip**  | **Açıklama**    |-------------------------------------------------------------------------|**Response**      | **Tip (Dict)**  | **Açıklama**    | 
| :--------      | :------- | :-------------- |:------------------------------------------------------------------------|:---------------- | :-------------- | :-------------- | 
|                |          |                 |                                                                         |                  |                 |                 | 

```
1- Örnek id ile kullanıcının silindiğinin doğrulanması
```
- src/test/java/tests/happyPathCases/BaseTests.java --> deleteUser()
- verifyGetUserById ucundan False beklenerek doğrulama gerçekleştirilmiştir. 
```
2- getUserList ucu ile alınan diğer id ile kullanıcının silindiğinin doğrulanması
```
- src/test/java/tests/happyPathCases/BaseId2Tests.java --> deleteUser()
- verifyGetUserById ucundan False beklenerek doğrulama gerçekleştirilmiştir. 
```
3- Boş id değeri ("") ile status code 200 dönmemesi       
```
- src/test/java/tests/negativeCases/GuidBlankTests.java --> blankGuidDeleteUser()
```
4- Boşluk id değeri (" ") ile status code 200 dönmemesi       
```
- src/test/java/tests/negativeCases/GuidSpaceTests.java --> spaceGuidDeleteUser()
```
5- Karakter guid değeri ("?!'^+%&/") ile status code 200 dönmemesi       
```
- src/test/java/tests/negativeCases/GuidCharacterTests.java --> characterGuidDeleteUser()
```
6- Doğru guid formatı fakat karakter ("!!!!!!!!-!!!!-!!!!-!!!!-!!!!!!!!!!!!") ile status code 200 dönmemesi       
```
- src/test/java/tests/negativeCases/GuidFormatButCharacterTests.java --> formatCharacterGuidDeleteUser()
```
7- Guid formatı sınır rakamlar ("99999999-9999-9999-9999-999999999999") ile status code 200 dönmemesi       
```
- src/test/java/tests/negativeCases/GuidNineTests.java --> nineGuidDeleteUser()
- Burada sadece 2 kullanıcı olduğu bilindiğinden bu test senaryosu yazılmıştır.
```
8- Guid formatı sınır rakamlar ("00000000-0000-0000-0000-000000000000") ile status code 200 dönmemesi       
```
- src/test/java/tests/negativeCases/GuidZeroTests.java --> zeroGuidDeleteUser()
- Buradaki test senaryosunun hatası ile daha önce karşılaşıldığı için yazılmıştır.

## Switch User Activity 
### |  PATCH     | ....../users/[guid]/activity 
| **Request**    | **Tip**  | **Açıklama**    |------------------------------------------------------------|**Response**      | **Tip (Dict)**  | **Açıklama**    | 
| :--------      | :------- | :-------------- |:---------------------------------------------------------- |:---------------- | :-------------- | :-------------- | 
| `isActive `    | `Boolean`| *Adı*           |                                                            | `userId`         | `guid`          | *Kullanıcı Id*  |
|                |          |                 |                                                            | `isActive`       | `Booelan`       | *Durum*         |
```
1- Örnek id ve bodyde gönderilen true parametresi ile kullanıcının aktivitesinin değiştiğinin doğrulanması
```
- src/test/java/tests/happyPathCases/BaseTests.java --> patchUserActivityTrue()
- verifyGetUserById ucundan isActive value değeri true beklenerek doğrulama gerçekleştirilmiştir. 
```
2- getUserList ucu ile alınan diğer id ve bodyde gönderilen true parametresi ile kullanıcının aktivitesinin değiştiğinin doğrulanması
```
- src/test/java/tests/happyPathCases/BaseId2Tests.java --> patchUserActivityTrue()
- verifyGetUserById ucundan isActive value değeri true beklenerek doğrulama gerçekleştirilmiştir.
```
3- Örnek id ve bodyde gönderilen false parametresi ile kullanıcının aktivitesinin değiştiğinin doğrulanması
```
- src/test/java/tests/happyPathCases/BaseTests.java --> patchUserActivityFalse()
- verifyGetUserById ucundan isActive value değeri false beklenerek doğrulama gerçekleştirilmiştir. 
```
4- getUserList ucu ile alınan diğer id ve bodyde gönderilen false parametresi ile kullanıcının aktivitesinin değiştiğinin doğrulanması
```
- src/test/java/tests/happyPathCases/BaseId2Tests.java --> patchUserActivityFalse()
- verifyGetUserById ucundan isActive value değeri false beklenerek doğrulama gerçekleştirilmiştir.
```
5- Boş id değeri ("") ile status code 200 dönmemesi       
```
- src/test/java/tests/negativeCases/GuidBlankTests.java --> blankGuidPatchUserActivity()
```
6- Boşluk id değeri (" ") ile status code 200 dönmemesi       
```
- src/test/java/tests/negativeCases/GuidSpaceTests.java --> spaceGuidPatchUserActivity()
```
7- Karakter guid değeri ("?!'^+%&/") ile status code 200 dönmemesi       
```
- src/test/java/tests/negativeCases/GuidCharacterTests.java --> characterGuidPatchUserActivity()
```
8- Doğru guid formatı fakat karakter ("!!!!!!!!-!!!!-!!!!-!!!!-!!!!!!!!!!!!") ile status code 200 dönmemesi       
```
- src/test/java/tests/negativeCases/GuidFormatButCharacterTests.java --> formatCharacterGuidPatchUserActivity()
```
9- Guid formatı sınır rakamlar ("99999999-9999-9999-9999-999999999999") ile status code 200 dönmemesi       
```
- src/test/java/tests/negativeCases/GuidNineTests.java --> nineGuidPatchUserActivity()
- Burada sadece 2 kullanıcı olduğu bilindiğinden bu test senaryosu yazılmıştır.
```
10- Guid formatı sınır rakamlar ("00000000-0000-0000-0000-000000000000") ile status code 200 dönmemesi       
```
- src/test/java/tests/negativeCases/GuidZeroTests.java --> zeroGuidPatchUserActivity()
- Buradaki test senaryosunun hatası ile daha önce karşılaşıldığı için yazılmıştır.

## Update User Info 
### |  PUT      | ....../users/[guid] 
| **Request**    | **Tip**  | **Açıklama**    |------------------------------------------------------------|**Response**      | **Tip (Dict)**  | **Açıklama**    | 
| :--------      | :------- | :-------------- |:---------------------------------------------------------- |:---------------- | :-------------- | :-------------- | 
| `firstName`    | `String` | *Adı*           |                                                            | `userId`         | `guid`          | *Kullanıcı Id*  | 
| `lastName`     | `String` | *Soyadı*        |                                                            |                  |                 |                 |                      
```
1- Örnek id ve bodyde gönderilen örnek parametreler ile kullanıcının güncellendiğinin doğrulanması
```
- src/test/java/tests/happyPathCases/BaseTests.java --> putUpdateUserInfo()
- getUserById ucundan firstName ve lastName değerleri ile doğrulama sağlanmıştır.
```
2- getUserList ucu ile alınan diğer id ve bodyde gönderilen örnek parametreler ile kullanıcının güncellendiğinin doğrulanması
```
- src/test/java/tests/happyPathCases/BaseId2Tests.java --> putUpdateUserInfo()
```
3- Örnek id ve bodyde gönderilen boş parametreler ile kullanıcının güncellenmediğinin doğrulanması
```
- src/test/java/tests/negativeCases/BlankBodyTests.java --> putUpdateUserInfo() 
```
4- getUserList ucu ile alınan diğer id ve bodyde gönderilen boş parametreler ile kullanıcının aktivitesinin değiştiğinin doğrulanması
```
- src/test/java/tests/happyPathCases/BaseId2Tests.java --> putUpdateUserInfo2().
```
5- Örnek id ve bodyde gönderilen karakter parametreleri ile kullanıcının güncellenmediğinin doğrulanması
```
- src/test/java/tests/negativeCases/CharacterBodyTests.java --> putUpdateUserInfo() 
```
6- getUserList ucu ile alınan diğer id ve bodyde gönderilen karakter parametreleri ile kullanıcının aktivitesinin değiştiğinin doğrulanması
```
- src/test/java/tests/negativeCases/CharacterBodyTests.java --> putUpdateUserInfo2().
```
7- Boş id değeri ("") ile status code 200 dönmemesi       
```
- src/test/java/tests/negativeCases/GuidBlankTests.java --> blankGuidPutUpdateUserInfo()
```
8- Boşluk id değeri (" ") ile status code 200 dönmemesi       
```
- src/test/java/tests/negativeCases/GuidSpaceTests.java --> spaceGuidPutUpdateUserInfo()
```
9- Karakter guid değeri ("?!'^+%&/") ile status code 200 dönmemesi       
```
- src/test/java/tests/negativeCases/GuidCharacterTests.java --> characterGuidPutUpdateUserInfo()
```
10- Doğru guid formatı fakat karakter ("!!!!!!!!-!!!!-!!!!-!!!!-!!!!!!!!!!!!") ile status code 200 dönmemesi       
```
- src/test/java/tests/negativeCases/GuidFormatButCharacterTests.java --> formatCharacterGuidPutUpdateUserInfo()
```
11- Guid formatı sınır rakamlar ("99999999-9999-9999-9999-999999999999") ile status code 200 dönmemesi       
```
- src/test/java/tests/negativeCases/GuidNineTests.java --> nineGuidPutUpdateUserInfo()
- Burada sadece 2 kullanıcı olduğu bilindiğinden bu test senaryosu yazılmıştır.
```
12- Guid formatı sınır rakamlar ("00000000-0000-0000-0000-000000000000") ile status code 200 dönmemesi       
```
- src/test/java/tests/negativeCases/GuidZeroTests.java --> zeroGuidPutUpdateUserInfo()
- Buradaki test senaryosunun hatası ile daha önce karşılaşıldığı için yazılmıştır.

## Projenin Kullanımı

Bu bölümde projenin gereksinimlerinden ve kullanmından bahsedilecektir. Projenin Intellij IDEA derleyicisi ile açılması tasiye edilir. pom.xml dosyasındaki gereksinimler yüklenir. Proje JDK 19.0.1 ile hazırlanmıştır.  

- https://mvnrepository.com/artifact/com.google.code.gson/gson
- https://mvnrepository.com/artifact/io.rest-assured/rest-assured
- https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api

Proje açılıp gereksinimler yüklendikten sonra proje içerisindeki test package üzerine sağ tıklanıp "Run" seçeneği ile test koşumu gerçekleştirilebilir.

## Proje Yapısı
Bu bölümde proje mimarisi açıklanmıştır.

**Utils**  
Tüm projeyi ilgilendiren değişkenler burada toplanmaktadır.  

**Methods**  
Bu package içerisinde ilgili API uçlarına restAssured ile istek atıp temel doğrulamaları yaparak yanıtı döndürecek methodlar bulunmaktadır.

**Models**  
Bu package içerisinde EndpointsMethods sınıfından elde edilen json yanıtlarının dönüşeceği model sınıfları bulunmaktadır.   

**Tests**  
Bu package içerisinde test sınıfları bulunmaktadır. Testler HappyPath ve NegativeCases olarak gruplandırılmıştır.  

## Özet

Postman ile yapılan otomasyonda 168 test içerisinde 38 test failed, 130 test passed durumundadır.

Java ile yapılan otomasyonda 46 test case içerisinde 31 test failed, 15 test passed durumundadır.

<p float="left">
  <img src="https://github.com/ssanemkaraa/ApiAutomationCase/blob/master/Results/Java_ApiBug.png" width="100" />
</p>
