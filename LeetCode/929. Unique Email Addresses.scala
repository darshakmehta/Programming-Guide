object Solution {
    def numUniqueEmails(emails: Array[String]): Int = {
        emails
          .map(mail => mail.split("[@]"))
          .map(mail => mail.head.split("[+]").head.replace(".", "") + mail.last)  
          .distinct
          .length
    }
}