package com.lcabral.core.common.domain.usecase

interface UseCaseProvider {
    suspend operator fun invoke(): List<String>
}
