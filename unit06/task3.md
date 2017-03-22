<!-- language: Java -->
class MedicalStaff{}  
class Doctor extends MedicalStaff {}  
class Nurse extends MedicalStaff{}  
class HeadDoctor extends Doctor{}  

|   | correct | not correct  | explanation  |
|---|---|---|---|
|  Doctor doctor1 = new Doctor(); |  [x] |[]  |Создание экземпляра своего класса.  |
|  Doctor doctor2 = new MedicalStaff(); |[]   | [x]  | Нельзя создать экземпляр родительского класса. |
|  Doctor doctor3 = new HeadDoctor(); |  [x] | []  | Можно создать экземпляр класса-наследника.  |
| Object object1 = new HeadDoctor();  |  [x] | []  | Все классы наследуются от Object, поэтому можно создать экземпляр HeadDoctor.
|  HeadDoctor doctor5 = new Object(); |  [] | [x]  |  Нельзя создать экземпляр родительского класса. |
| Doctor doctor6 = new Nurse();  | []  | [x]  | Оба класса наследуются от одного предка, но не имеют родства друг с другом.  |
|  Nurse nurse = new Doctor(); |  [] |[x]   |  Оба класса наследуются от одного предка, но не имеют родства друг с другом. |
|  Object object2 = new Nurse(); |  [x] | []  | Все классы наследуются от Object, поэтому можно создать экземпляр Nurse.  |
|List \<Doctor> list1= new ArrayList\<Doctor>();   |  [x] | []  | Arraylist содержащий объекты Doctor имплементирует интерфейс List параметризованный тем же типом. |
|  List\<MedicalStaff> list2 = new ArrayList\<Doctor>(); |  [] | [x]  | Arraylist содержащий объекты Doctor не может имплементировать интерфейс List  параметризованный MedicalStaff. Валидной была бы запись List\<? extends MedicalStaff> list4 = new ArrayList\<Doctor>();|
| List\<Doctor> list3 = new ArrayList\<MedicalStaff>();  |[]   | [x]  | Arraylist содержащий объекты MedicalStaff не может имплементировать интерфейс List параметризованный Doctor. ? extends тут не сработает так как Doctor - наследник MedicalStaff.
|  List\<Object> list4 = new ArrayList\<Doctor>(); |  [] |  [x] |  Arraylist содержащий объекты Doctor не может имплементировать интерфейс List параметризованный Object. Валидной была бы запись  List\<? extends Object> list4 = new ArrayList\<Doctor>(); |
|  List\<Object> list5 = new ArrayList\<Object>(); |  [x] | []  |Arraylist содержащий объекты Object имплементирует интерфейс List параметризованный тем же типом.   |