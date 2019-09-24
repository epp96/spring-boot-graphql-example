package com.example.springbootgraphqlexample.service.dataFetcher;



import com.example.springbootgraphqlexample.model.Book;
import com.example.springbootgraphqlexample.repository.BookRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BookDataFetcher implements DataFetcher<Book> {

    @Autowired
    BookRepository bookRepository;

    @Override
    public Book get(DataFetchingEnvironment dataFetchingEnvironment) {

        String isn = dataFetchingEnvironment.getArgument("id");
//        Book exampleBook = new Book();
//        exampleBook.setIsn(isn);
//        Example<Book> example = Example.of(exampleBook);
//
//        Optional<Book> optionalBook = bookRepository.findOne(example);
//
//        return optionalBook.get();
        return bookRepository.findById(isn).get();
    }
}
