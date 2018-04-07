package cz.muni.ib053.crossRoadSimulator.controller

import cz.muni.ib053.crossRoadSimulator.entity.Semaphore
import cz.muni.ib053.crossRoadSimulator.repository.SemaphoreRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/semaphore")
class SemaphoreController(private val semaphoreRepository: SemaphoreRepository) {

    @GetMapping("/all")
    fun getAll(): List<Semaphore> {
        return semaphoreRepository.findAll();
    }


}



//@GetMapping("/articles")
//fun getAllArticles(): List<Article> =
//        articleRepository.findAll()
//
//
//@PostMapping("/articles")
//fun createNewArticle(@Valid @RequestBody article: Article): Article =
//        articleRepository.save(article)
//
//
//@GetMapping("/articles/{id}")
//fun getArticleById(@PathVariable(value = "id") articleId: Long): ResponseEntity<Article> {
//    return articleRepository.findById(articleId).map { article ->
//        ResponseEntity.ok(article)
//    }.orElse(ResponseEntity.notFound().build())
//}
//
//@PutMapping("/articles/{id}")
//fun updateArticleById(@PathVariable(value = "id") articleId: Long,
//                      @Valid @RequestBody newArticle: Article): ResponseEntity<Article> {
//
//    return articleRepository.findById(articleId).map { existingArticle ->
//        val updatedArticle: Article = existingArticle
//                .copy(title = newArticle.title, content = newArticle.content)
//
//        ResponseEntity.ok().body(articleRepository.save(updatedArticle))
//    }.orElse(ResponseEntity.notFound().build())
//
//}
//
//@DeleteMapping("/articles/{id}")
//fun deleteArticleById(@PathVariable(value = "id") articleId: Long): ResponseEntity<Void> {
//
//    return articleRepository.findById(articleId).map { article  ->
//        articleRepository.delete(article)
//        ResponseEntity<Void>(HttpStatus.OK)
//    }.orElse(ResponseEntity.notFound().build())
//
//}
