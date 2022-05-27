package com.ida.challengechapter7.di

import com.ida.challengechapter7.data.Repository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val repositoryModule = module {
    singleOf(::Repository)

}