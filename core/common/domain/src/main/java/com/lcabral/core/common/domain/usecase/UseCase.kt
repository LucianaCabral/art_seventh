package com.lcabral.core.common.domain.usecase

interface UseCase {
 suspend operator fun invoke(): List<String>
}
