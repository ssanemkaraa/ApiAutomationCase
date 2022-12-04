
# GoArt Case

Bu proje GoArt tarafından iletilen API servisi için yazılmış bir Java Maven test otomasyon projesidir. Bu projede amaç, API uçlarının olası tüm test senaryolarının otomatize edilmesidir.

## Api Hakkında
API uçları ve aldıkları parametreler hakkında gerekli bilgiler aşağıda verilmiştir. İlgili uca ait test senaryoları açıklanmıştır.


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
2- Her istekte yeni bir kullanıcı id oluşması
3- Body parametresi olmadan kullanıcı oluşmaması
4- Password dışındakiler zorunlu parametre
```

## Get User List
### | GET        |... /users 
| **Request**    | **Tip**  | **Açıklama**    |---------------------------------------------------------------------|**Response**      | **Tip (List)**  | **Açıklama**    | 
| :--------      | :------- | :-------------- |:--------------------------------------------------------------------|:---------------- | :-------------- | :-------------- | 
|                |          |                 |                                                                     | `id`             | `guid`          | *Kullanıcı Id*  | 
|                |          |                 |                                                                     | `username `      | `String`        | *Kullanıcı Adı* |                       
|                |          |                 |                                                                     | `firstName`      | `String`        | *Adı*           | 
|                |          |                 |                                                                     | `flastName`      | `String`        | *Soyadı*        |
|                |          |                 |                                                                     | `isActive`       | `Booelan`       | *Durum*         |

```
1-
```
## Get User By Id
### | GET        |... /users/[guid] 
| **Request**    | **Tip**  | **Açıklama**    |--------------------------------------------------------------------|**Response**      | **Tip (Dict)**  | **Açıklama**    | 
| :--------      | :------- | :-------------- |:-------------------------------------------------------------------|:---------------- | :-------------- | :-------------- | 
|                |          |                 |                                                                    | `id`             | `guid`          | *Kullanıcı Id*  | 
|                |          |                 |                                                                    | `username `      | `String`        | *Kullanıcı Adı* |                       
|                |          |                 |                                                                    | `firstName`      | `String`        | *Adı*           | 
|                |          |                 |                                                                    | `flastName`      | `String`        | *Soyadı*        |
|                |          |                 |                                                                    | `isActive`       | `Booelan`       | *Durum*         |

```
1-
```
## Remove User
### | DELETE     |... /users/[guid] 
| **Request**    | **Tip**  | **Açıklama**    |-------------------------------------------------------------------------|**Response**      | **Tip (Dict)**  | **Açıklama**    | 
| :--------      | :------- | :-------------- |:------------------------------------------------------------------------|:---------------- | :-------------- | :-------------- | 
|                |          |                 |                                                                         |                  |                 |                 | 

```
1-
```
## Switch User Activity 
### |  PATCH     | ....../users/[guid]/activity 
| **Request**    | **Tip**  | **Açıklama**    |------------------------------------------------------------|**Response**      | **Tip (Dict)**  | **Açıklama**    | 
| :--------      | :------- | :-------------- |:---------------------------------------------------------- |:---------------- | :-------------- | :-------------- | 
| `isActive `    | `Boolean`| *Adı*           |                                                            | `userId`         | `guid`          | *Kullanıcı Id*  |
|                |          |                 |                                                            | `isActive`       | `Booelan`       | *Durum*         |
```
1-
```

## Update User Info 
### |  PUT      | ....../users/[guid] 
| **Request**    | **Tip**  | **Açıklama**    |------------------------------------------------------------|**Response**      | **Tip (Dict)**  | **Açıklama**    | 
| :--------      | :------- | :-------------- |:---------------------------------------------------------- |:---------------- | :-------------- | :-------------- | 
| `firstName`    | `String` | *Adı*           |                                                            | `userId`         | `guid`          | *Kullanıcı Id*  | 
| `lastName`     | `String` | *Soyadı*        |                                                            |                  |                 |                 |                      
```
1-
```

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
