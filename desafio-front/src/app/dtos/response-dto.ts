export interface ResponseDto<T> {
    code: number,
    status: string,
    messages: Array<string>,
    result: T
}