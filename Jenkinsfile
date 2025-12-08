pipeline{
// jenkins içerisinde jdk ve maven i tanımladık bu sayede localdeki jdk ve maven a bakmayacak
tools{
jdk 'JDK21'
maven 'Maven-3.9'
}

// stages sırayla jenkins in çalıştıracağını komutlar.
stages{
// ilk adımda github tan projeyi çekip main branche checout oluyor
    stage('Checkout')
    git branch: 'master',
    url:'https://github.com/BRC1234210/E-junkie-Project.git'


// 2. stepte testleri çalıştırıyor.
   stage('Run test')

   // Mac (mac olanlar bu satırı kullanacak)
   sh 'mvn clean test'


   //Windows (windows olanlar bu satırı kullanacak)
   //bat 'mvn clean test'

// bu stepte ise reportu oluşturuyoruz
   stage('Generate Allure Report')
   // allure result un oluştuğu klasörü tanımladık
   allure([
   results:[[path:'target/allure-results']
   ])

}
}